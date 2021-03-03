package com.example.demo.select.company;

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

import com.example.demo.result.DeleteForm;
import com.example.demo.result.company.CompanyForm;
import com.example.demo.security.login.UserDetailsImpl;

@Controller
@RequestMapping(Control.PAGE_URL)
public class Control {
	public static final String PAGE_URL = "/select/company";
	
	@ModelAttribute
	CompanyForm companyForm() {
		return new CompanyForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@Autowired
	SelectCompanyDatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay(@ModelAttribute RequestForm form) {
		return PAGE_URL;
	}
	
	@PostMapping("result")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RequestForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		SelectForm select = new SelectForm(form,user.getCompanyId());
		//今回は羅列検索のみ
		model.addAttribute("ResultForm",mapper.selectList(select));
		return PAGE_URL;
	}
}
