package form.insert;

import javax.validation.constraints.Pattern;

import constant.RegexpMessage;
import constant.RegexpPattern;

public class RevenueForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String earningsId;
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String money;
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
	public String getMoney() {
		return money;
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
