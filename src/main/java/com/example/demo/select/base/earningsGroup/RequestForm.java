package com.example.demo.select.base.earningsGroup;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class RequestForm {
	@Pattern(regexp = RegexpPattern.ID_OR_NAME, message = RegexpMessage.ID_OR_NAME)
	private String company;
	
	@Pattern(regexp = RegexpPattern.RANGE_DATE, message = RegexpMessage.RANGE_DATE)
	private String earningsDate;
	
	@Pattern(regexp = RegexpPattern.RANGE_INTEGER, message = RegexpMessage.RANGE_INTEGER)
	private String money;
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCheckDisplayed() {
		return checkDisplayed;
	}
	public void setCheckDisplayed(String checkDisplayed) {
		this.checkDisplayed = checkDisplayed;
	}
	public String getCheckGroupItem() {
		return checkGroupItem;
	}
	public void setCheckGroupItem(String checkGroupItem) {
		this.checkGroupItem = checkGroupItem;
	}
	public String getCheckGroupMonth() {
		return checkGroupMonth;
	}
	public void setCheckGroupMonth(String checkGroupMonth) {
		this.checkGroupMonth = checkGroupMonth;
	}
	public String getCheckGroupYear() {
		return checkGroupYear;
	}
	public void setCheckGroupYear(String checkGroupYear) {
		this.checkGroupYear = checkGroupYear;
	}
}
