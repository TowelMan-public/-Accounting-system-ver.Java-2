package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class ConfigurationTaxRateForm {
	@Pattern(regexp = RegexpPattern.RATE, message = RegexpMessage.RATE)
	private String afterConsumptionTax;

	public String getAfterConsumptionTax() {
		return afterConsumptionTax;
	}

	public void setAfterConsumptionTax(String afterConsumptionTax) {
		this.afterConsumptionTax = afterConsumptionTax;
	}
}
