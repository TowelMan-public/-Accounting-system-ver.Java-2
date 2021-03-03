package com.example.demo.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.security.login.UserDetailsImpl;

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
