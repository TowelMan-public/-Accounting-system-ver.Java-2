package com.example.demo.select.expenses;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class RequestForm {
	private String subject;
	@Pattern(regexp = RegexpPattern.ID_OR_NAME, message = RegexpMessage.ID_OR_NAME)
	private String expenses;
	@Pattern(regexp = RegexpPattern.RANGE_DATE, message = RegexpMessage.RANGE_DATE)
	private String date;
	@Pattern(regexp = RegexpPattern.RANGE_INTEGER, message = RegexpMessage.RANGE_INTEGER)
	private String money;
	private String checkDisplayed;
	private String checkGroupExpenses;
	private String checkGroupMonth;
	private String checkGroupYear;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExpenses() {
		return expenses;
	}
	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getCheckGroupExpenses() {
		return checkGroupExpenses;
	}
	public void setCheckGroupExpenses(String checkGroupExpenses) {
		this.checkGroupExpenses = checkGroupExpenses;
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