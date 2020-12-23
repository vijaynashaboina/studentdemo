package com.infy.exception;

public class StudentValidationException extends StudentException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentValidationException(String messageCode,Object...args) {
		super(messageCode,args);
	}

}
