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
import com.example.demo.form.select.BaseEarningsGroupForm;
import com.example.demo.repository.select.base.earnings.group.SelectNetIncomeMapper;

@Controller
@RequestMapping("/select/netIncome")
public class NetIncomeControl extends BaseEarningsGroupControl{
	
	@Autowired
	SelectNetIncomeMapper mapper;
	
	@GetMapping
	public String showDisplay(@ModelAttribute BaseEarningsGroupForm form) {
		return "/select/netIncome";
	}
	
	@PostMapping("result")
	@Override
	public String select(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute @Valid BaseEarningsGroupForm form, BindingResult bindingResult, Model model) {
		super.datebaceMapper = mapper;
		super.groupItemName = "純利益";
		super.groupItemTypeName="会社";
		super.selectUrl = "netIncome";
		
		return super.select(user, form, bindingResult, model);
	}
}