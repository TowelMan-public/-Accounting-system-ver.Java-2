package com.example.demo.entity.select;

public class ExpensesResultEntity {
	private Integer expensesNumber;
	private String subject;
	private String expensesDate;
	private String expensesItem;
	private Integer money;
	
	public Integer getExpensesNumber() {
		return expensesNumber;
	}
	public void setExpensesNumber(Integer expensesNumber) {
		this.expensesNumber = expensesNumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExpensesDate() {
		return expensesDate;
	}
	public void setExpensesDate(String expensesDate) {
		this.expensesDate = expensesDate;
	}
	public String getExpensesItem() {
		return expensesItem;
	}
	public void setExpensesItem(String expensesItem) {
		this.expensesItem = expensesItem;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
}
