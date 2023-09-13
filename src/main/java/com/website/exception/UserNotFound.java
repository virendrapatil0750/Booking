package com.website.exception;

public class UserNotFound extends RuntimeException {
	  
	
	private String message;

	public UserNotFound() {}

	public UserNotFound(String message) {
		super(message);
		this.message = message;
	}
	
	
	
	
	

}
