package com.example.demo.form.result;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class CompanyForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String companyId;
	@NotBlank(message = RegexpMessage.EMPTY)
	private String companyName;
	//setterが、加工必須 boolean
	private String isDisplayed;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public String getCompanyId() {
		return companyId;
	}
	public Integer getCompanyIdToInteger() {
		return Integer.parseInt(companyId);
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public boolean getIsDisplayed() {
		return isDisplayed.equals("true");
	}
	public void setIsDisplayed(String isDisplayed) {
		this.isDisplayed = isDisplayed;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
