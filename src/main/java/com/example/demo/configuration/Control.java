package com.example.demo.configuration;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.Authority;
import com.example.demo.security.login.UserDetailsImpl;
import com.example.demo.verification.Message;

@Controller()
@RequestMapping(Control.PAGE_URL)
public class Control {
	public static final String PAGE_URL = "/confinguration";
	private static final String REDIRECT_URL = "redirect;" + PAGE_URL;
	
	@Autowired
	ConfigurationDatabaseMapper mapper;
	
	@ModelAttribute
	CompanyUserForm companyUserForm() {
		return new CompanyUserForm();
	}
	
	@ModelAttribute
	IdForm idForm() {
		return new IdForm();
	}
	
	@ModelAttribute
	ConfigurationTaxRateForm configurationTaxRateForm() {
		return new ConfigurationTaxRateForm();
	}
	
	@ModelAttribute
	CompanyConfigurationForm companyConfigurationForm() {
		return new CompanyConfigurationForm();
	}
	
	@GetMapping
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
		setAll(user,model);
		return PAGE_URL;
	}
	
	private void setAll(UserDetailsImpl user, Model model) {
		setTaxRate(user,model);
		setCompany(user,model);
		setUserListInCompany(user,model);
	}
	
	private void setTaxRate(UserDetailsImpl user, Model model) {
		//現在設定されている消費税率のセット
		var taxForm = new ConfigurationTaxRateForm();
		taxForm.setAfterConsumptionTax(mapper.getConsumptionTax(user.getCompanyId()).toString());
		model.addAttribute("configurationTaxRateForm",taxForm);
	}
	
	private void setCompany(UserDetailsImpl user, Model model) {
		//会社のなまえとIDのセット
		var companyForm = new CompanyConfigurationForm();
		companyForm.setAfterCompanyName(user.getCompanyName());
		companyForm.setCompanyId(user.getCompanyId());
		model.addAttribute("companyConfigurationForm",companyForm);
	}
	
	private void setUserListInCompany(UserDetailsImpl user, Model model) {
		//その会社に登録されているユーザーリストのセット
		model.addAttribute("out_companyUserForm",mapper.selectUsersByCompanyId( user.getCompanyId() ));
	}
	
	@PostMapping("user/update")
	public String updateUser(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyUserForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors()) {
			setAll(user,model);
			return PAGE_URL;
		}
		
		//有効でないユーザーであればエラーメッセージをセットしてこの関数を終了
		if(!mapper.isEnabledUser(form.getUserIdToInteger(),user.getCompanyId())) {
			model.addAttribute("isErrorUserUpdate", true);
			model.addAttribute("errorUserUpdate", Message.ID_ISNOT_ENABLED);
			setAll(user,model);
			return PAGE_URL;
		}
		
		//対象のユーザーが変更できるかを判定
		if(enableUpdate(user,form)) {
			mapper.updateUser(form);
			return REDIRECT_URL;
		}else {//エラーメッセージ
			model.addAttribute("isErrorUserUpdate", true);
			model.addAttribute("errorUserUpdate", "この変更は、マスター権限者が無くなってしまうのでできません");
			setAll(user,model);
			return PAGE_URL;
		}
	}

	@PostMapping("user/delete")
	public String deleteUser(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid IdForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors()) {
			setAll(user,model);
			return PAGE_URL;
		}
		
		//有効でないユーザーであればエラーメッセージをセットしてこの関数を終了
		if(!mapper.isEnabledUser(form.getIdToInt(),user.getCompanyId())) {
			model.addAttribute("isErrorUserDelete", true);
			model.addAttribute("errorUserDelete", Message.ID_ISNOT_ENABLED);
			setAll(user,model);
			return PAGE_URL;
		}
		
		//対象のユーザーが削除できるかを判定
		if(enableDelete(user,form)) {
			mapper.deleteUser(form);
			return REDIRECT_URL;
		}else {//エラーメッセージ
			model.addAttribute("isErrorUserDelete", true);
			model.addAttribute("errorUserDelete", "このユーザーを削除するとマスター権限者が無くなってしまうのでできません");
			setAll(user,model);
			return PAGE_URL;
		}
	}

	@PostMapping("taxRate/update")
	public String updateTaxRate(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid ConfigurationTaxRateForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors()) {
			setCompany(user,model);
			setUserListInCompany(user,model);
			return PAGE_URL;
		}
		
		form.setCompanyId(user.getCompanyId());
		mapper.updateConsumptionTaxRate(form);
		return REDIRECT_URL;
	}
	
	@PostMapping("company/update")
	public String updateCompany(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyConfigurationForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors()) {
			setTaxRate(user,model);
			setUserListInCompany(user,model);
			return PAGE_URL;
		}
		
		form.setCompanyId(user.getCompanyId());
		mapper.updateCompanyName(form);
		user.setCompanyName(form.getAfterCompanyName());
		return REDIRECT_URL;
	}
	
	private boolean enableUpdate(UserDetailsImpl user, CompanyUserForm form) {
		if(form.getUserAuthority().equals(Authority.USER) && mapper.getAuthorityByUserId(form.getUserIdToInteger()).equals(Authority.MASTER)) {
			//変更可能か判定し、削除不可能ならここでfalseを返す
			return mapper.getMasterAuthorityCountInCompany(user.getCompanyId()) <= 1;
		}
		return true;
	}
	
	private boolean enableDelete(UserDetailsImpl user, IdForm form) {
		if(mapper.getAuthorityByUserId(form.getIdToInt()).equals(Authority.MASTER)) {
			//削除可能か判定し、削除不可能ならここでfalseを返す
			return mapper.getMasterAuthorityCountInCompany(user.getCompanyId()) <= 1;
		}
		return true;
	}
}
