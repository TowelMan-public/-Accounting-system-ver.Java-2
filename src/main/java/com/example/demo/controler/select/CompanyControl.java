package com.example.demo.controler.select;

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

import com.example.demo.dto.select.CompanyDto;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.result.DeleteForm;
import com.example.demo.form.select.CompanyForm;
import com.example.demo.repository.select.SelectCompanyMapper;

@Controller
@RequestMapping(CompanyControl.PAGE_URL)
public class CompanyControl {
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
	SelectCompanyMapper mapper;
	
	@GetMapping
	public String showDisplay(@ModelAttribute CompanyForm form) {
		return PAGE_URL;
	}
	
	@PostMapping("result")
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		CompanyDto select = new CompanyDto(form,user.getCompanyId());
		//今回は羅列検索のみ
		model.addAttribute("ResultForm",mapper.selectList(select));
		return PAGE_URL;
	}
}
