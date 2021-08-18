package com.posts.exception;

public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(String message, Throwable arg1) {
		super(message, arg1);
	}

	public IdNotFoundException(String message) {
		super(message);
	}

	public IdNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
	

}
