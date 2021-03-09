package com.example.demo.controler.select.base.earnings.group;

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

import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.result.RevenueForm;
import com.example.demo.form.select.BaseEarningsGroupForm;
import com.example.demo.repository.select.base.earnings.group.SelectIncomeMapper;

@Controller
@RequestMapping("/select/income")
public class IncomeControl extends BaseEarningsGroupControl{
	
	@Autowired
	SelectIncomeMapper mapper;
	
	@ModelAttribute
	RevenueForm revenueForm() {
		return new RevenueForm();
	}
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsGroupForm form) {
		return "/select/income";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsGroupForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "所得";
		super.groupItemTypeName="会社";
		super.selectUrl = "income";
		
		return super.select(user, form, bindingResult, model);
	}
}