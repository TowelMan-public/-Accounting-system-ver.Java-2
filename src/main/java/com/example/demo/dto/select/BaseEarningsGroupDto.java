package com.example.demo.dto.select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.constant.RegexpPattern;
import com.example.demo.form.select.BaseEarningsGroupForm;

public class BaseEarningsGroupDto {
	//company
	private String companyName;
	private Integer companyId;
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
	//companyAccountId
	private Integer companyAccountId;
	
	public BaseEarningsGroupDto(BaseEarningsGroupForm form, Integer companyAccount) {
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
			matcher.matches();
			start = matcher.group(1);
			finish = matcher.group(2);
		}
		this.earningsDateStart = start;
		this.earningsDateFinish = finish;
		
		//check系
		this.checkDisplayed = form.getCheckDisplayed().equals("true");
		this.checkGroupItem = form.getCheckGroupItem().equals("true");
		this.checkGroupYear = form.getCheckGroupYear().equals("true");
		this.checkGroupMonth = (this.checkGroupYear ? false :form.getCheckGroupMonth().equals("true"));
		
		//companyAccountId
		companyAccountId = companyAccount;
	}

	public String getCompanyName() {
		if(companyName == null)
			return null;
		return "%" + companyName + "%";
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

	public String getEarningsDateStart() {
		return earningsDateStart;
	}

	public void setEarningsDateStart(String earningsDateStart) {
		this.earningsDateStart = earningsDateStart;
	}

	public String getEarningsDateFinish() {
		return earningsDateFinish;
	}

	public void setEarningsDateFinish(String earningsDateFinish) {
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

	public Integer getCompanyAccountId() {
		return companyAccountId;
	}

	public void setCompanyAccountId(Integer companyAccountId) {
		this.companyAccountId = companyAccountId;
	}
}
