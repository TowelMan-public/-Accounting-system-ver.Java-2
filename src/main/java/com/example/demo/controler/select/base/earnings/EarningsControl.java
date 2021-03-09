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
import com.example.demo.form.result.DeleteForm;
import com.example.demo.form.result.EarningsForm;
import com.example.demo.form.select.BaseEarningsForm;
import com.example.demo.repository.select.base.earnings.SelectEarningsMapper;

@Controller
@RequestMapping("/select/earnings")
public class EarningsControl extends BaseEarningsControl{
	
	@Autowired
	SelectEarningsMapper mapper;
	
	@ModelAttribute
	EarningsForm earningsForm() {
		return new EarningsForm();
	}
	
	@ModelAttribute
	DeleteForm deleteForm() {
		return new DeleteForm();
	}
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsForm form) {
		return "/select/earnings";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "売上";
		super.groupItemTypeName="会社";
		super.selectUrl = "earnings";
		
		return super.select(user, form, bindingResult, model);
	}
}