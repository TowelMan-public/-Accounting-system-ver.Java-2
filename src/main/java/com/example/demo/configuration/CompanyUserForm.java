package com.example.demo.configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class CompanyUserForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private Integer userId;
	
	@NotNull(message = RegexpMessage.EMPTY)
	@Pattern(regexp = RegexpPattern.EMPTY, message = RegexpMessage.EMPTY)
	private String userName;
	
	@Pattern(regexp = RegexpPattern.AUTHORITY, message = RegexpMessage.AUTHORITY)
	private String userAuthority;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}
}
