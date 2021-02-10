package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class IdForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private String id;

	public Integer getId() {
		return Integer.parseInt(id);
	}

	public void setId(@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)String id) {
		this.id = id;
	}
	
	public void setId(Integer id) {
		this.id = id.toString();
	}
}
