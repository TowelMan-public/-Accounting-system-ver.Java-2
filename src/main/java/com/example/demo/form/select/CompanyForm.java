package com.example.demo.form.select;

import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class CompanyForm {	
	@Pattern(regexp = RegexpPattern.ID_OR_NAME, message = RegexpMessage.ID_OR_NAME)
	private String company;
	private String isDisplayed;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIsDisplayed() {
		return isDisplayed == null ? "" : isDisplayed;
	}
	public void setIsDisplayed(String isDisplayed) {
		this.isDisplayed = isDisplayed;
	}
}