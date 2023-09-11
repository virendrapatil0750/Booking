package com.website.exception;

public class UserAlreadyExists extends RuntimeException {
	
	private String message;
	public UserAlreadyExists() {}
	
	public UserAlreadyExists(String message) {
		super(message);
		this.message = message;
	}
	
}
