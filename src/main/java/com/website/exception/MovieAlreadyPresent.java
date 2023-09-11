package com.website.exception;

public class MovieAlreadyPresent extends RuntimeException {
	private String message;
	
	public MovieAlreadyPresent() {};
	
	public MovieAlreadyPresent(String message) {
		super(message);
		this.message = message;
	}
}
