package com.example.demo.form.insert;

import java.util.regex.Matcher;

import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class ExpensesForm {
	@Pattern(regexp = RegexpPattern.ID_OR_ID_AND_NAME, message = RegexpMessage.ID_OR_ID_AND_NAME)
	private String expensesItem;
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String expensesDate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String money;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public String getExpensesItem() {
		if(expensesItem == null) 
			return "";
		else {
			Integer output = getExpensesItemToInteger();
			return output == null ? "" : output.toString();
		}
	}
	public Integer getExpensesItemToInteger() {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(RegexpPattern.ID_AND_NAME);
		Matcher matcher = pattern.matcher(expensesItem);
		
		if(matcher.matches()) {//IDと名前がセットで入力されている
			return Integer.parseInt(matcher.group(1));
		}else if(expensesItem.matches(RegexpPattern.INTEGER)) {//IDのみが入力されている
			return Integer.parseInt(expensesItem);
		}else
			return null;
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
	public String getMoney() {
		return money;
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
