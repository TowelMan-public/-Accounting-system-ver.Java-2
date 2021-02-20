package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class IdForm {
	public IdForm(@Pattern(regexp = "^[0-9]+$", message = "整数で入力してください") String id) {
		this.id = id;
	}

	public IdForm() {}
	
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String id;

	public String getId() {
		return id;
	}
	
	public Integer getIdToInt() {
		return Integer.parseInt(id);
	}

	public void setId(String id) {
		this.id = id;
	}
}
