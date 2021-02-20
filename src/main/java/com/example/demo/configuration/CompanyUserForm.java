package com.example.demo.configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class CompanyUserForm {
	public CompanyUserForm(@Pattern(regexp = "^[0-9]+$", message = "整数で入力してください") String userId,
			@NotBlank(message = "何かしら入力してください（空っぽはだめです）") String userName,
			@Pattern(regexp = "^(MASTER)|(USER)$", message = "権限は「MASTER」か「USER」でお願いします") String userAuthority) {
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
