package com.example.demo;

import com.example.demo.security.Authority;

public class RegexpPattern {
	static final public String INTEGER = "^[%d]+$";
	static final public String AUTHORITY = "^(" + Authority.master + ")|(" + Authority.user + ")$";
	static final public String EMPTY = "^$";
	static final public String RATE = "^[0-1]|(0\\.[%d]+)$";
	static final public String ID_OR_NAME = "^(([%d]+)|([.]*))?$";
	static final public String DATE = "^([1-2][0-9]{3})////(0?[1-9]|1[0-2])////(0?[1-9]|[12][0-9]|3[01])$";
	static final public String RANGE = "^([.]*)-([.]*)$";
	static final public String RANGE_DATE = "^((" + DATE + ")-(" + DATE + "))|(" + DATE + ")?$";
	static final public String RANGE_INTEGER = "^((" + INTEGER + ")-(" + INTEGER + "))|(" + INTEGER + ")?$";
}
