package form.configuration;

import javax.validation.constraints.Pattern;

import constant.RegexpMessage;
import constant.RegexpPattern;

public class ConfigurationTaxRateForm {
	public ConfigurationTaxRateForm(
			@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE) String afterConsumptionTax,
			Integer companyId) {
		this.afterConsumptionTax = afterConsumptionTax;
		this.companyId = companyId;
	}

	public ConfigurationTaxRateForm() {}
	
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)
	private String afterConsumptionTax;
	//入力ﾁｪｯｸなし
	private Integer companyId;

	public String getAfterConsumptionTax() {
		return afterConsumptionTax;
	}

	public void setAfterConsumptionTax(String afterConsumptionTax) {
		this.afterConsumptionTax = afterConsumptionTax;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
