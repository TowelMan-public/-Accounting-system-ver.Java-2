package com.example.demo.controler.result;

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

import com.example.demo.constant.VerificationMessage;
import com.example.demo.dto.select.CompanyDto;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.result.CompanyForm;
import com.example.demo.form.result.DeleteForm;
import com.example.demo.repository.DeleteMapper;
import com.example.demo.repository.UpdateMapper;
import com.example.demo.repository.VerificationMapper;
import com.example.demo.repository.select.SelectCompanyMapper;

@Controller
@RequestMapping(CompanyControl.PAGE_URL)
public class CompanyControl {
	public static final String PAGE_URL = "/result/company";
	
	@Autowired
	UpdateMapper updateMapper;
	@Autowired
	DeleteMapper deleteMapper;
	@Autowired
	VerificationMapper verificationMapper;
	@Autowired
	SelectCompanyMapper selectMapper;
	
	@ModelAttribute
	CompanyForm companyForm() {
		return new CompanyForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@PostMapping("update")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//CompanyAccountIdをセットする
		form.setCompanyAccountId(user.getCompanyId());
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledCompanyId(user.getCompanyId(), form.getCompanyIdToInteger())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "comapnyId", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//更新
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			updateMapper.updateCompany(form);
		
		//検索
		CompanyDto select = new CompanyDto(user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		return PAGE_URL;
	}
	
	@PostMapping("delete")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid DeleteForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//各IDが、有効かどうかをチェックする
		if( !verificationMapper.isEnabledCompanyId(user.getCompanyId(), form.getIdToInt())) {//有効でない
			FieldError error = new FieldError(bindingResult.getObjectName(), "id", VerificationMessage.ID_ISNOT_ENABLED);
			bindingResult.addError(error);
		}
		
		//削除
		if (!bindingResult.hasErrors())//エラーが発生してないときのみ処理を実行
			deleteMapper.deleteCompany(user.getCompanyId(), form.getIdToInt());
		
		//検索
		CompanyDto select = new CompanyDto(user.getCompanyId());
		model.addAttribute("ResultForm",selectMapper.selectList(select));
		return PAGE_URL;
	}
}
