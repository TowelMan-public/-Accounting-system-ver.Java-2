package com.example.demo.insert.company;

import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;

public class CompanyForm {
	@NotBlank(message = RegexpMessage.EMPTY)
	private String companyName;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
