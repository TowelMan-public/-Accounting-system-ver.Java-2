package com.example.demo.entity;

import com.example.demo.form.MakeNewComanyAccountForm;

public class CompanyAccountEntity {
	private Integer companyId;
	private String companyName;
	
	public CompanyAccountEntity(MakeNewComanyAccountForm form) {
		this.companyName = form.getCompanyName();
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
