package com.example.demo.controler.select.base.earnings;

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
import com.example.demo.form.select.BaseEarningsForm;
import com.example.demo.repository.select.base.earnings.SelectRevenueMapper;

@Controller
@RequestMapping("/select/revenue")
public class RevenueControl extends BaseEarningsControl{
	
	@Autowired
	SelectRevenueMapper mapper;
	
	@ModelAttribute
	RevenueForm revenueForm() {
		return new RevenueForm();
	}
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsForm form) {
		return "/select/revenue";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "収入";
		super.groupItemTypeName="会社";
		super.selectUrl = "revenue";
		
		return super.select(user, form, bindingResult, model);
	}
}