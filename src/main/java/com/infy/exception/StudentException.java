package com.infy.exception;

import com.infy.util.ApplicationConstants;

public class StudentException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  Object[] args;
	
	public String messageCode;
	
	public StudentException() {
		this(ApplicationConstants.DEFAULT_ERROR_MESSAGE,new Object[] {});
	}
	
	public StudentException(final String messagecode) {
		this(messagecode,new Object[] {});
	}
	
	public StudentException(final String messageCode,final Object... args) {
		super(messageCode);
		this.messageCode=messageCode;
		this.args=args;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	
	

}
