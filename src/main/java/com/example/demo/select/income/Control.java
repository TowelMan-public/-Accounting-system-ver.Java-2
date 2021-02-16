package com.example.demo.select.income;

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

import com.example.demo.security.login.UserDetailsImpl;
import com.example.demo.select.base.earningsGroup.BaseControl;
import com.example.demo.select.base.earningsGroup.RequestForm;

@Controller
@RequestMapping("/select/income")
public class Control extends BaseControl{
	
	@Autowired
	SelectIncomeDatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay() {
		return "/select/income";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RequestForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "所得";
		super.groupItemTypeName="会社";
		super.selectUrl = "income";
		
		return super.select(user, form, bindingResult, model);
	}
}