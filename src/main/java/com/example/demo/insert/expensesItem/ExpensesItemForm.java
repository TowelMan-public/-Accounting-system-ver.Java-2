package com.example.demo.insert.expensesItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ExpensesItemForm {
	@NotBlank(message = RegexpMessage.EMPTY)
	private String expensesItemName;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)//getterがDouble
	private String Rate;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public String getExpensesItemName() {
		return expensesItemName;
	}
	public void setExpensesItemName(String expensesItemName) {
		this.expensesItemName = expensesItemName;
	}
	public Double getRate() {
		return Double.parseDouble(Rate);
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
	
}
