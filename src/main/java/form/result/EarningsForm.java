package form.result;

import javax.validation.constraints.Pattern;

import constant.RegexpMessage;
import constant.RegexpPattern;

public class EarningsForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String earningsId;
	@Pattern(regexp = RegexpPattern.DATE, message = RegexpMessage.DATE)
	private String earningsDate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String company;
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)
	private String taxRate;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String money;
	//省略可
	private String personName;
	//省略可
	private String subject;
	//CompanyAccountIdを、Controlクラスでセットする
	private Integer companyAccountId;
	
	public String getEarningsId() {
		return earningsId;
	}
	public Integer getEarningsIdToInteger() {
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
	public String getCompany() {
		return company;
	}
	public Integer getCompanyToInteger() {
		return Integer.parseInt(company);
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getMoney() {
		return money;
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
