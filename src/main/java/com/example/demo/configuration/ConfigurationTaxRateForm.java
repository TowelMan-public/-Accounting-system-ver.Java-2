package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ConfigurationTaxRateForm {
	public ConfigurationTaxRateForm(
			@Pattern(regexp = "^[0-1]|(0\\.[0-9]+)$", message = "率の指定は、0以上1以下でお願いします") String afterConsumptionTax,
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
