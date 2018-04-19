package com.niit.skillMap.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	
	public boolean checkName(String name)
	{
		if(name.equals(""))
			return false;
		else
			return true;
	}
	public boolean checkEmail(String email)
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if(matcher.matches())
			return true;
		else
			return false;
	}
}
