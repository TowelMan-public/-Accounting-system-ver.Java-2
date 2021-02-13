package com.example.demo.result.company;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class CompanyForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String companyId;
	@NotBlank(message = RegexpMessage.EMPTY)
	private String companyName;
	//setterが、加工必須 boolean
	private String isDisplayed;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public Integer getCompanyId() {
		return Integer.parseInt(companyId);
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Integer getCompanyName() {
		return Integer.parseInt(companyName);
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