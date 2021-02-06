package com.example.demo.select.consumptionTax;

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
import com.example.demo.select.base.earnings.BaseControl;
import com.example.demo.select.base.earnings.RequestForm;

@Controller
@RequestMapping("/select/consumptionTax")
public class Control extends BaseControl{
	
	@Autowired
	DatabaseMapper mapper;
	
	@GetMapping
	public String showDisplay() {
		return "/select/consumptionTax";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid RequestForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "消費税";
		super.groupItemTypeName="会社";
		super.selectUrl = "consumptionTax";
		
		return super.select(user, form, bindingResult, model);
	}
}