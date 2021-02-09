package com.example.demo.result.revenue;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class RevenueForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String earningsId;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)//getterがInteger
	private String money;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	public Integer getEarningsId() {
		return Integer.parseInt(earningsId);
	}
	public void setEarningsId(String earningsId) {
		this.earningsId = earningsId;
	}
	public Integer getMoney() {
		return Integer.parseInt(money);
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getCompanyAccountId() {
		return companyAccountId;
	}
	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
