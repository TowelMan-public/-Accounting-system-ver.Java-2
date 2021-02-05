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

@Controller
@RequestMapping("/confingration")
public class Control {	
	//定数群
	private final String isnotEnabledUserMessage = "指定されたユーザーは有効ではありません。もう一回よくご確認ください。";
	
	@Autowired
	DatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
		//現在設定されている消費税率のセット
		model.addAttribute("beforConsumptionTax",mapper.getConsumptionTax( user.getCompanyId() ));
		
		//会社IDのセット
		model.addAttribute("companyId",user.getCompanyId());
		
		//現在指定されている会社の名前
		model.addAttribute("beforCompanyName",user.getCompanyName());
		
		//その会社に登録されているユーザーリストのセット
		model.addAttribute("companyUserForm",mapper.selectUsersByCompanyId( user.getCompanyId() ));
		
		return "/confingration";
	}
	
	@PostMapping("user/update")
	public String updateUser(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyUserForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/confingration";
		
		//有効でないユーザーであればエラーメッセージをセットしてこの関数を終了
		if(!mapper.isEnabledUser(form.getUserId())) {
			model.addAttribute("isErrorUserUpdate", true);
			model.addAttribute("errorUserUpdate", isnotEnabledUserMessage);
		}
		
		//対象のユーザーが変更できるかを判定
		if(enableUpdate(user,form)) {
			mapper.updateUser(form);
		}else {//エラーメッセージ
			model.addAttribute("isErrorUserUpdate", true);
			model.addAttribute("errorUserUpdate", "この変更は、マスター権限者が無くなってしまうのでできません");
		}
		return "redirect:/confingration";
	}

	@PostMapping("user/delete")
	public String deleteUser(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid IdForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/confingration";
		
		//有効でないユーザーであればエラーメッセージをセットしてこの関数を終了
		if(!mapper.isEnabledUser(form.getId())) {
			model.addAttribute("isErrorUserUpdate", true);
			model.addAttribute("errorUserDelete", isnotEnabledUserMessage);
		}
		
		//対象のユーザーが削除できるかを判定
		if(enableDelete(user,form)) {
			mapper.deleteUser(form);
		}else {//エラーメッセージ
			model.addAttribute("isErrorUserDelete", true);
			model.addAttribute("errorUserDelete", "このユーザーを削除するとマスター権限者が無くなってしまうのでできません");
		}
		return "redirect:/confingration";
	}

	@PostMapping("taxRate/update")
	public String updateTaxRate(@ModelAttribute @Valid ConfigurationTaxRateForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/confingration";
		
		mapper.updateConsumptionTaxRate(form);
		return "redirect:/confingration";
	}
	
	@PostMapping("company/update")
	public String updateCompany(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyConfigurationForm form, BindingResult bindingResult) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return "redirect:/confingration";
		
		form.setCompanyId(user.getCompanyId());
		mapper.updateCompanyName(form);
		return "redirect:/confingration";
	}
	
	private boolean enableUpdate(UserDetailsImpl user, CompanyUserForm form) {
		if(form.getUserAuthority().equals(Authority.user) && mapper.getAuthorityByUserId(form.getUserId()).equals(Authority.master)) {
			//削除可能か判定し、削除不可能ならここでfalseを返す
			if(mapper.getMasterAuthorityCountInCompany(user.getCompanyId()) <= 0)
				return false;
		}
		return true;
	}
	
	private boolean enableDelete(UserDetailsImpl user, IdForm form) {
		if(mapper.getAuthorityByUserId(form.getId()).equals(Authority.master)) {
			//削除可能か判定し、削除不可能ならここでfalseを返す
			if(mapper.getMasterAuthorityCountInCompany(user.getCompanyId()) <= 0)
				return false;
		}
		return true;
	}
}
