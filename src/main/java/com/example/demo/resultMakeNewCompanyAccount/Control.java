package com.example.demo.resultMakeNewCompanyAccount;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resultMakeNewCompanyAccount")
public class Control {	
	@GetMapping
	public String showDisplay(Model model) {		
		return "/resultMakeNewCompanyAccount";
	}
}
