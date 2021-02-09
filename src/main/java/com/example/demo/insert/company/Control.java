package com.example.demo.insert.company;

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

import com.example.demo.insert.InsertDatabaseMapper;
import com.example.demo.security.login.UserDetailsImpl;

@Controller
@RequestMapping("/insert/company")
public class Control {
	@Autowired
	InsertDatabaseMapper insertMapper;
	
	@GetMapping()
	public String showDisplay(@AuthenticationPrincipal UserDetailsImpl user, Model model) {		
		return "/insert/company";
	}
	
	@PostMapping("insert")
	public String insert(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid CompanyForm form, BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸ
		if (bindingResult.hasErrors())
			return "redirect:/result/company";
		
		//formにcompanyAccountIdをセット
		form.setCompanyAccountId(user.getCompanyId());
		
		//追加
		insertMapper.insertCompany(form);
		return "/insert/company";
	}
}