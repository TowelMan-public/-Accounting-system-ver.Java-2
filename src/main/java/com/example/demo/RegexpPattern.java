package com.example.demo;

import com.example.demo.security.Authority;

public class RegexpPattern {
	static final public String INTEGER = "^[%d]+$";
	static final public String AUTHORITY = "^[" + Authority.master + "]|[" + Authority.user + "]$";
	static final public String EMPTY = "^$";
	static final public String RATE = "^[0-1]|[0\\.[%d]+]$";
}
