package com.example.demo.configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class CompanyConfigurationForm {
	@NotNull(message = RegexpMessage.EMPTY)
	@Pattern(regexp = RegexpPattern.EMPTY, message = RegexpMessage.EMPTY)
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
