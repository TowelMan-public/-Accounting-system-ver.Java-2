package com.example.demo.form.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.constant.RegexpMessage;
import com.example.demo.constant.RegexpPattern;

public class DeleteForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public Integer getIdToInt() {
		return Integer.parseInt(this.id);
	}
}