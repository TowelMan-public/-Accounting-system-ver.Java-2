package com.example.demo.controler.select;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/select")
public class SelectControl {	
	@GetMapping
	public String showDisplay(Model model) {		
		return "/select";
	}
}
