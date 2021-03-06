package dto.select;

import constant.RegexpPattern;
import form.select.CompanyForm;

public class CompanyDto {
	//company
	private Integer companyId;
	private String companyName;
	//isDisplayed
	private boolean isDisplayed;
	//companyAccountId
	private Integer companyAccountId;
	
	public CompanyDto(CompanyForm form, Integer companyAccount) {
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
		
		//isDisplayed
		this.isDisplayed = form.getIsDisplayed().equals("true");
		
		//companyAccountId
		companyAccountId = companyAccount;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		if(companyName == null)
			return null;
		return "%" + companyName + "%";
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
