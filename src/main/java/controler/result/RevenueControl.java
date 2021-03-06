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
import form.result.RevenueForm;
import form.select.BaseEarningsForm;
import repository.DeleteDatabaseMapper;
import repository.UpdateDatabaseMapper;
import repository.VerificationDatabaseMapper;
import repository.select.base.earnings.SelectRevenueDatabaseMapper;

@Controller
@RequestMapping(RevenueControl.PAGE_URL)
public class RevenueControl {
	public static final String PAGE_URL = "/result/revenue";
	
	@Autowired
	UpdateDatabaseMapper updateMapper;
	@Autowired
	DeleteDatabaseMapper deleteMapper;
	@Autowired
	VerificationDatabaseMapper verificationMapper;
	@Autowired
	SelectRevenueDatabaseMapper selectMapper;
	
	@ModelAttribute
	RevenueForm revenueForm() {
		return new RevenueForm();
	}
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RevenueForm form, BindingResult bindingResult, Model model) {
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
		
		//更新して終了
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateRevenue(form);
		
		BaseEarningstDto select = new BaseEarningstDto(new BaseEarningsForm(),user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		
		return PAGE_URL;
	}
}