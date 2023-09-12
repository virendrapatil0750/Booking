package com.website.exception;

public class UserPasswordisWrong extends RuntimeException {
	private String message;

	public UserPasswordisWrong() {}

	public UserPasswordisWrong(String message) {
		super();
		this.message = message;
	}

}
