package com.sbassement.exception;

public class ProductAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ProductAlreadyExistsException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}


}
