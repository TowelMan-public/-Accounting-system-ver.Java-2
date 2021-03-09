package com.example.demo.form.insert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class ExpensesItemForm {
	@NotBlank(message = RegexpMessage.EMPTY)
	private String expensesItemName;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)
	private String rate;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
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
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
	
}
