package com.example.demo.makeNewCompanyAccount;

public class CompanyAccountForm {
	private Integer companyId;
	private String companyName;
	
	public CompanyAccountForm(MakeNewComanyAccountForm form) {
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
