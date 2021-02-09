package com.example.demo.result.earnings;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class EarningsForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String earningsId;
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String earningsDate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//TODO 候補付にする可能性あり //getterがInteger
	private String company;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)//getterがDouble
	private String taxRate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String money;
	//省略可
	private String personName;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public Integer getEarningsId() {
		return Integer.parseInt(earningsId);
	}
	public void setEarningsId(String earningsId) {
		this.earningsId = earningsId;
	}
	public String getEarningsDate() {
		return earningsDate;
	}
	public void setEarningsDate(String earningsDate) {
		this.earningsDate = earningsDate;
	}
	public Integer getCompany() {
		return Integer.parseInt(company);
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Double getTaxRate() {
		return Double.parseDouble(taxRate);
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public Integer getMoney() {
		return Integer.parseInt(money);
	}
	public void setMoney(String money) {
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
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
