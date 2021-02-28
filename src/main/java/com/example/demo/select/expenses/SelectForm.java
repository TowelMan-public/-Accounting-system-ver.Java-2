package com.example.demo.select.expenses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.RegexpPattern;

public class SelectForm {
	//expenses
	private String expensesName;
	private Integer expensesId;
	//文字列コピーのみ
	private String subject;
	//expensesDate
	private String expensesDateStart;
	private String expensesDateFinish;
	//money
	private Integer moneyStart;
	private Integer moneyFinish;
	//check系 日付のグループ指定は一つまでで「年ごと」の指定優先
	private boolean checkDisplayed;
	private boolean checkGroupItem;
	private boolean checkGroupMonth;
	private boolean checkGroupYear;
	private boolean checkGroup;
	//companyAccountId
	private Integer companyAccountId;
	
	public SelectForm(RequestForm form, Integer companyAccount) {
		//範囲のあるやつで使用
		String start,finish;
		
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
		
		//文字列コピーのみ
		this.subject = form.getSubject().equals("") ? null : form.getSubject();
		
		//companyDate
		if(form.getDate().equals("")) {
			//未指定
			start = finish = null;
		}else if(form.getDate().matches(RegexpPattern.DATE)) {
			//startのみに指定されていることが確実
			start = form.getDate();
			finish = null;
		}else {//「-」を使って表されている
			//正規表現を作成
			Pattern pattern = Pattern.compile(RegexpPattern.RANGE);
			Matcher matcher = pattern.matcher(form.getDate());
			start = matcher.group(1);
			finish = matcher.group(2);
		}
		this.expensesDateStart = start;
		this.expensesDateFinish = finish;
		
		//money
		if(form.getMoney().equals("")) {
			//未指定
			start = finish = null;
		}else if(form.getMoney().matches(RegexpPattern.INTEGER)) {
			//startのみに指定されていることが確実
			start = form.getMoney();
			finish = null;
		}else {//「-」を使って表されている
			//正規表現を作成
			Pattern pattern = Pattern.compile(RegexpPattern.RANGE);
			Matcher matcher = pattern.matcher(form.getMoney());
			start = matcher.group(1);
			finish = matcher.group(2);
		}
		this.moneyStart = (start==null ? null : Integer.parseInt(start));
		this.moneyFinish = (finish==null ? null : Integer.parseInt(finish));
		
		//check系
		this.checkDisplayed = form.getCheckDisplayed().equals("true");
		this.checkGroupItem = form.getCheckGroupExpenses().equals("true");
		this.checkGroupYear = form.getCheckGroupYear().equals("true");
		this.checkGroupMonth = (this.checkGroupYear ? false :form.getCheckGroupMonth().equals("true"));
		this.checkGroup 
				= this.checkDisplayed || this.checkGroupItem || this.checkGroupMonth || this.checkGroupYear;
		//companyAccountId
		companyAccountId = companyAccount;
	}

	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}

	public Integer getExpensesId() {
		return expensesId;
	}

	public void setExpensesId(Integer expensesId) {
		this.expensesId = expensesId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExpensesDateStart() {
		return expensesDateStart;
	}

	public void setExpensesDateStart(String expensesDateStart) {
		this.expensesDateStart = expensesDateStart;
	}

	public String getExpensesDateFinish() {
		return expensesDateFinish;
	}

	public void setExpensesDateFinish(String expensesDateFinish) {
		this.expensesDateFinish = expensesDateFinish;
	}

	public Integer getMoneyStart() {
		return moneyStart;
	}

	public void setMoneyStart(Integer moneyStart) {
		this.moneyStart = moneyStart;
	}

	public Integer getMoneyFinish() {
		return moneyFinish;
	}

	public void setMoneyFinish(Integer moneyFinish) {
		this.moneyFinish = moneyFinish;
	}

	public boolean isCheckDisplayed() {
		return checkDisplayed;
	}

	public void setCheckDisplayed(boolean checkDisplayed) {
		this.checkDisplayed = checkDisplayed;
	}

	public boolean isCheckGroupItem() {
		return checkGroupItem;
	}

	public void setCheckGroupItem(boolean checkGroupItem) {
		this.checkGroupItem = checkGroupItem;
	}

	public boolean isCheckGroupMonth() {
		return checkGroupMonth;
	}

	public void setCheckGroupMonth(boolean checkGroupMonth) {
		this.checkGroupMonth = checkGroupMonth;
	}

	public boolean isCheckGroupYear() {
		return checkGroupYear;
	}

	public void setCheckGroupYear(boolean checkGroupYear) {
		this.checkGroupYear = checkGroupYear;
	}

	public boolean isCheckGroup() {
		return checkGroup;
	}

	public void setCheckGroup(boolean checkGroup) {
		this.checkGroup = checkGroup;
	}

	public Integer getCompanyAccountId() {
		return companyAccountId;
	}

	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
