package com.sbassement.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmployeeAlreadyExistsException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

}
