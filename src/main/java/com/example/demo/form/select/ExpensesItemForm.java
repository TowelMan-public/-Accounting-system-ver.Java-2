package com.example.demo.form.select;

import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class ExpensesItemForm {
	@Pattern(regexp = RegexpPattern.ID_OR_NAME, message = RegexpMessage.ID_OR_NAME)
	private String expenses;
	private String checkDisplayed;
	public String getExpenses() {
		return expenses;
	}
	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}
	public String getCheckDisplayed() {
		return checkDisplayed == null ? "" : checkDisplayed;
	}
	public void setCheckDisplayed(String checkDisplayed) {
		this.checkDisplayed = checkDisplayed;
	}
	
	
}
