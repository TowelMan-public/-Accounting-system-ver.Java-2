package com.example.demo.configuration;

import javax.validation.constraints.Pattern;

import com.example.demo.RegexpMessage;
import com.example.demo.RegexpPattern;

public class IdForm {
	@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(@Pattern(regexp = RegexpPattern.INTEGER, message = RegexpMessage.INTEGER)String id) {
		this.id = Integer.parseInt(id);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
