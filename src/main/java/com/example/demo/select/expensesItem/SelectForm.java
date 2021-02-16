package com.example.demo.select.expensesItem;

import com.example.demo.RegexpPattern;

public class SelectForm {
	//company
	private Integer expensesId;
	private String expensesName;
	//isDisplayed
	private boolean isDisplayed;
	//companyAccountId
	private Integer companyAccountId;
	
	public SelectForm(RequestForm form, Integer companyAccount) {
		//company
		if(form.getExpenses().matches(RegexpPattern.INTEGER)) {
			//整数だからID取得
			this.expensesId = Integer.parseInt(form.getExpenses());
			this.expensesName = null;
		}else {
			//文字列だから名前取得
			this.expensesName = ( (form.getExpenses().equals("")) ? null : form.getExpenses() );
			this.expensesId = null;
		}
		
		//isDisplayed
		this.isDisplayed = form.getCheckDisplayed().equals("true");
		
		//companyAccountId
		companyAccountId = companyAccount;
	}

	public Integer getExpensesId() {
		return expensesId;
	}

	public void setExpensesId(Integer expensesId) {
		this.expensesId = expensesId;
	}

	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}

	public boolean isDisplayed() {
		return isDisplayed;
	}

	public void setDisplayed(boolean isDisplayed) {
		this.isDisplayed = isDisplayed;
	}

	public Integer getCompanyAccountId() {
		return companyAccountId;
	}

	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
