package com.bridgelabz.exception;

@SuppressWarnings("serial")
public class ExceptionResponse extends RuntimeException {

	public ExceptionResponse(String message) {
		super(message);
	}
}