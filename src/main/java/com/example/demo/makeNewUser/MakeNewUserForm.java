package com.example.demo.makeNewUser;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;

public class MakeNewUserForm {
	@NotBlank(message = RegexpMessage.EMPTY)
	private String userName;
	
	@NotBlank(message = RegexpMessage.EMPTY)
	private String password;
	
	@NotBlank(message = RegexpMessage.EMPTY)
	private String oneMorePassword;
	
	@AssertTrue(message = "2つのパスワードが合致しません。もう一度お確かめください")
	public boolean isNotMatchesPassword() {
		if(password.equals(oneMorePassword))
			return true;
		else
			return false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOneMorePassword() {
		return oneMorePassword;
	}

	public void setOneMorePassword(String oneMorePassword) {
		this.oneMorePassword = oneMorePassword;
	}
}
