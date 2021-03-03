package com.example.demo.configuration;

import javax.validation.constraints.NotBlank;

import com.example.demo.RegexpMessage;

public class CompanyConfigurationForm {
	@NotBlank(message = RegexpMessage.EMPTY)
	private String afterCompanyName;
	//入力ﾁｪｯｸなし
	private Integer companyId;
	
	public String getAfterCompanyName() {
		return afterCompanyName;
	}
	public void setAfterCompanyName(String afterCompanyName) {
		this.afterCompanyName = afterCompanyName;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
