package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ConfigurationTaxRateForm {
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
