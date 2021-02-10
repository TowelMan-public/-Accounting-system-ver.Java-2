package com.example.demo.select.base.earnings;

public class ResultForm {
	private Integer earningsNumber;
	private String earningsDate;
	private String company;
	private Double tax;
	private Integer money;
	private String personName;
	private String subject;
	public Integer getEarningsNumber() {
		return earningsNumber;
	}
	public void setEarningsNumber(Integer earningsNumber) {
		this.earningsNumber = earningsNumber;
	}
	public String getEarningsDate() {
		return earningsDate;
	}
	public void setEarningsDate(String earningsDate) {
		this.earningsDate = earningsDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
}
