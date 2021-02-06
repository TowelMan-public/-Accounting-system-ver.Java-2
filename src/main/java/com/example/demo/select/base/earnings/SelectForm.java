package com.example.demo.select.base.earnings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.RegexpPattern;

public class SelectForm {
	//company
	private String companyName;
	private Integer companyId;
	//文字列コピーのみ
	private String subject;
	private String person;
	//companyDate
	private String earningsDateStart;
	private String earningsDateFinish;
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
		if(form.getCompany().matches(RegexpPattern.INTEGER)) {
			//整数だからID取得
			this.companyId = Integer.parseInt(form.getCompany());
			this.companyName = null;
		}else {
			//文字列だから名前取得
			this.companyName = ( (form.getCompany().equals("")) ? null : form.getCompany() );
			this.companyId = null;
		}
		
		//文字列コピーのみ
		this.subject = form.getSubject();
		this.person = form.getPerson();
		
		//companyDate
		if(form.getEarningsDate().equals("")) {
			//未指定
			start = finish = null;
		}else if(form.getEarningsDate().matches(RegexpPattern.DATE)) {
			//startのみに指定されていることが確実
			start = form.getEarningsDate();
			finish = null;
		}else {//「-」を使って表されている
			//正規表現を作成
			Pattern pattern = Pattern.compile(RegexpPattern.RANGE);
			Matcher matcher = pattern.matcher(form.getEarningsDate());
			start = matcher.group(1);
			finish = matcher.group(2);
		}
		this.earningsDateStart = start;
		this.earningsDateFinish = finish;
		
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
		this.checkGroupItem = form.getCheckGroupItem().equals("true");
		this.checkGroupYear = form.getCheckGroupYear().equals("true");
		this.checkGroupMonth = (this.checkGroupYear ? false :form.getCheckGroupMonth().equals("true"));
		this.checkGroup 
				= this.checkDisplayed || this.checkGroupItem || this.checkGroupMonth || this.checkGroupYear;
		//companyAccountId
		companyAccountId = companyAccount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getEarningsDateStart() {
		return earningsDateStart;
	}

	public void setEarningsDateStart(String earningsDateStart) {
		this.earningsDateStart = earningsDateStart;
	}

	public String getEarningsDateFinish() {
		return earningsDateFinish;
	}

	public void setEearningsDateFinish(String earningsDateFinish) {
		this.earningsDateFinish = earningsDateFinish;
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

	public Integer getCompanyAccountId() {
		return companyAccountId;
	}

	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}

	public boolean isCheckGroup() {
		return checkGroup;
	}

	public void setCheckGroup(boolean checkGroup) {
		this.checkGroup = checkGroup;
	}

	public boolean isCheckGroupItem() {
		return checkGroupItem;
	}

	public void setCheckGroupItem(boolean checkGroupItem) {
		this.checkGroupItem = checkGroupItem;
	}
}
