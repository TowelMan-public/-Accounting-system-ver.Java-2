package form.insert;

import java.util.regex.Matcher;

import javax.validation.constraints.Pattern;

import constant.RegexpMessage;
import constant.RegexpPattern;

public class EarningsForm {
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String earningsDate;
	@Pattern(regexp = RegexpPattern.ID_OR_ID_AND_NAME, message = RegexpMessage.ID_OR_ID_AND_NAME)
	private String company;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String money;
	//省略可
	private String personName;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	//earningsIdを、DatabaseMapperに取得させて、後処理に使う
	private Long earningsId;
	
	public String getEarningsDate() {
		return earningsDate;
	}
	public void setEarningsDate(String earningsDate) {
		this.earningsDate = earningsDate;
	}
	
	public String getCompany() {
		if(company == null)
			return this.company;
		else{
			Integer output = getCompanyToInteger();
			return output == null ? "" : output.toString();
		}
	}
	
	public Integer getCompanyToInteger() {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(RegexpPattern.ID_AND_NAME);
		Matcher matcher = pattern.matcher(company);
		
		if(matcher.matches()) {//IDと名前がセットで入力されている
			return Integer.parseInt(matcher.group(1));
		}else if(company.matches(RegexpPattern.INTEGER)) {//IDのみが入力されている
			return Integer.parseInt(company);
		}else
			return null;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMoney() {
		return this.money;
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
	public Long getEarningsId() {
		return earningsId;
	}
	public void setEarningsId(Long earningsId) {
		this.earningsId = earningsId;
	}
	
}
