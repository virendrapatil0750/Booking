package com.website.exception;

public class AdminNotFoundExecption extends RuntimeException {
	private String message;
	
	
	public AdminNotFoundExecption() {
	}


	public AdminNotFoundExecption(String message) {
		super(message);
		this.message = message;
	}
}
