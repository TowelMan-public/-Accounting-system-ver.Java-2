package com.example.demo.insert.expenses;

import java.util.regex.Matcher;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ExpensesForm {
	@Pattern(regexp = RegexpPattern.ID_OR_ID_AND_NAME, message = RegexpMessage.ID_OR_ID_AND_NAME)//getterがInteger
	private String expensesItem;
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String expensesDate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String money;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public Integer getExpensesItem() {
		if(expensesItem.matches(RegexpPattern.ID_AND_NAME)) {//IDと名前がセットで入力されている
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(RegexpPattern.ID_AND_NAME);
			Matcher matcher = pattern.matcher(expensesItem);
			return Integer.parseInt(matcher.group(1));
		}else {//IDのみが入力されている
			return Integer.parseInt(expensesItem);
		}
	}
	public void setExpensesItem(String expensesItem) {
		this.expensesItem = expensesItem;
	}
	public String getExpensesDate() {
		return expensesDate;
	}
	public void setExpensesDate(String expensesDate) {
		this.expensesDate = expensesDate;
	}
	public Integer getMoney() {
		return Integer.parseInt(money);
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
	
}
