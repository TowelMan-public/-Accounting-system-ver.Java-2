package com.example.demo.makeNewCompanyAccount;

import com.example.demo.security.SecurityRepository;

public class UserForm {
	private Integer userid;
	private String userName;
	private String password;
	private Integer companyId;
	private String authority;
	
	public UserForm(MakeNewComanyAccountForm form) {
		this.userName = form.getUserName();
		//パスワードを暗号化して取得
		this.password = SecurityRepository.encryption(form.getPassword());
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
