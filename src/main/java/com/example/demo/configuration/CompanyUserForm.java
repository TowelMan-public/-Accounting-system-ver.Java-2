package com.example.demo.configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class CompanyUserForm {
	public CompanyUserForm(@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER) String userId,
			@NotBlank(message = RegexpMessage.EMPTY) String userName,
			@Pattern(regexp = RegexpPattern.AUTHORITY, message = RegexpMessage.AUTHORITY) String userAuthority) {
		this.userId = userId;
		this.userName = userName;
		this.userAuthority = userAuthority;
	}

	public CompanyUserForm() {}
	
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String userId;
	
	@NotBlank(message = RegexpMessage.EMPTY)
	private String userName;
	
	@Pattern(regexp = RegexpPattern.AUTHORITY, message = RegexpMessage.AUTHORITY)
	private String userAuthority;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Integer getUserIdToInteger() {
		return Integer.parseInt(userId);
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
