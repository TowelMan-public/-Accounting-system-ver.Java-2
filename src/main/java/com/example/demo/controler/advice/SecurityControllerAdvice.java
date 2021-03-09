package com.example.demo.controler.advice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.constant.Authority;
import com.example.demo.entity.UserDetailsImpl;

//各リクエストの共通処理
@ControllerAdvice
public class SecurityControllerAdvice {
	
	@ModelAttribute("isMASTER")
	public String addIsMASTER(@AuthenticationPrincipal UserDetailsImpl user) {
		if(user == null)
			return "false";
		else
			return user.getAuthoritie().equals(Authority.MASTER)?"true":"false";
	}
}
