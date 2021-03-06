package controler.result;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.VerificationMessage;
import dto.select.BaseEarningstDto;
import entity.UserDetailsImpl;
import form.result.DeleteForm;
import form.result.EarningsForm;
import form.select.BaseEarningsForm;
import repository.DeleteDatabaseMapper;
import repository.UpdateDatabaseMapper;
import repository.VerificationDatabaseMapper;
import repository.select.SelectEarningsDatabaseMapper;

@Controller
@RequestMapping(EarningsControl.PAGE_URL)
public class EarningsControl {
	public static final String PAGE_URL = "/result/earnings";
	
	@Autowired
	UpdateDatabaseMapper updateMapper;
	@Autowired
	DeleteDatabaseMapper deleteMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	@Autowired
	SelectEarningsDatabaseMapper selectMapper;
	
	@ModelAttribute
	EarningsForm earningsForm() {
		return new EarningsForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid EarningsForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getEarningsIdToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "earningsId", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		if( !verificationMapper.isEnabledCompanyId(user.getCompanyId(), form.getCompanyToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "company", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateEarnings(form);
		
		//検索用フォーム作成
		BaseEarningstDto select = new BaseEarningstDto(new BaseEarningsForm(),user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		
		return PAGE_URL;
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledEarningsId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteEarnings(user.getCompanyId(), form.getIdToInt());
		
		//検索用フォーム作成
		BaseEarningstDto select = new BaseEarningstDto(new BaseEarningsForm(),user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		
		return PAGE_URL;
	}
}