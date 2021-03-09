package com.example.demo.entity.select;

public class CompanyResultEntity {
	private Integer companyNumber;
	private String companyName;
	private boolean isDisplayed;
	
	public Integer getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(Integer companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public boolean isDisplayed() {
		return isDisplayed;
	}
	public void setDisplayed(boolean isDisplayed) {
		this.isDisplayed = isDisplayed;
	}
}
