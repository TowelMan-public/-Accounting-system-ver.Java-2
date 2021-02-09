package com.example.demo.result.expensesItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ExpensesItemForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String expensesItemId;
	@NotBlank(message = RegexpMessage.EMPTY)
	private String expensesItemName;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)//getterがDouble
	private String rate;
	//setterが、加工必須
	private String isDisplayed;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	public Integer getExpensesItemId() {
		return Integer.parseInt(expensesItemId);
	}
	public void setExpensesItemId(String expensesItemId) {
		this.expensesItemId = expensesItemId;
	}
	public String getExpensesItemName() {
		return expensesItemName;
	}
	public void setExpensesItemName(String expensesItemName) {
		this.expensesItemName = expensesItemName;
	}
	public Double getRate() {
		return Double.parseDouble(rate);
	}
	public void setRate(String rate) {
		this.rate = rate;
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