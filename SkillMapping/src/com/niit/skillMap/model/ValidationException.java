package com.niit.skillMap.model;

public class ValidationException extends Exception {

	private String message;
	public ValidationException(String message) {
		super(message);
		this.message=message;
	}
	@Override
	public String toString() {
		return message;
	}
	
}
