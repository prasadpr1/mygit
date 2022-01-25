package com.sbassement.exception;

public class MandatroyFieldsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public MandatroyFieldsException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}