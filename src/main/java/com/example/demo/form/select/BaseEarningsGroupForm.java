package com.example.demo.form.select;

import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class BaseEarningsGroupForm {
	@Pattern(regexp = RegexpPattern.ID_OR_NAME, message = RegexpMessage.ID_OR_NAME)
	private String company;
	
	@Pattern(regexp = RegexpPattern.RANGE_DATE, message = RegexpMessage.RANGE_DATE)
	private String earningsDate;
	
	private String checkDisplayed;
	private String checkGroupItem;
	private String checkGroupMonth;
	private String checkGroupYear;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEarningsDate() {
		return earningsDate;
	}
	public void setEarningsDate(String earningsDate) {
		this.earningsDate = earningsDate;
	}
	public String getCheckDisplayed() {
		return checkDisplayed == null ? "" : checkDisplayed;
	}
	public void setCheckDisplayed(String checkDisplayed) {
		this.checkDisplayed = checkDisplayed;
	}
	public String getCheckGroupItem() {
		return checkGroupItem == null ? "" : checkGroupItem;
	}
	public void setCheckGroupItem(String checkGroupItem) {
		this.checkGroupItem = checkGroupItem;
	}
	public String getCheckGroupMonth() {
		return checkGroupMonth == null ? "" : checkGroupMonth;
	}
	public void setCheckGroupMonth(String checkGroupMonth) {
		this.checkGroupMonth = checkGroupMonth;
	}
	public String getCheckGroupYear() {
		return checkGroupYear == null ? "" : checkGroupYear;
	}
	public void setCheckGroupYear(String checkGroupYear) {
		this.checkGroupYear = checkGroupYear;
	}
}
