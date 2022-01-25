/**
 * 
 */
package com.sbassement.exception;

/**
 * Custom exception.
 * @author Sraven
 *
 */

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmployeeNotFoundException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}


}
