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
	private static final String PHONE_PATTERN = "^[0-9]{10}$";
	
	private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,20}$";
	private Pattern pattern;
	private Matcher matcher;
	
	public boolean checkName(String name)
	{
		if(!(name.equals("")))
			return true;
		else
			return false;
	}
	public boolean checkEmail(String email)
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if(matcher.matches() && (!email.equals("")))
			return true;
		else
			return false;
	}
	public boolean checkPhone(String phone)
	{
		pattern = Pattern.compile(PHONE_PATTERN);
		matcher = pattern.matcher(phone);
		if(matcher.matches() && (!phone.equals("")))
			return true;
		else
			return false;
	}
	
	public boolean checkCity(String city)
	{
		if(!(city.equals("")))
			return true;
		else
			return false;
	}
	public boolean checkPassword(String password)
	{
		pattern = Pattern.compile(PHONE_PATTERN);
		matcher = pattern.matcher(password);
		if(matcher.matches() && (!password.equals("")))
			return true;
		else
			return false;
	}
}
