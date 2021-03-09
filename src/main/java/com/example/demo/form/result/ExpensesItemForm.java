package com.example.demo.form.result;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class ExpensesItemForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String expensesItemId;
	@NotBlank(message = RegexpMessage.EMPTY)
	private String expensesItemName;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)
	private String rate;
	//setterが、加工必須
	private String isDisplayed;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	public String getExpensesItemId() {
		return expensesItemId;
	}
	public Integer getExpensesItemIdToInteger() {
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
	public String getRate() {
		return rate;
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