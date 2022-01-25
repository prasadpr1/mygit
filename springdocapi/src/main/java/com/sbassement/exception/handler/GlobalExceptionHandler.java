/**
 * 
 */
package com.sbassement.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sbassement.exception.EmployeeAlreadyExistsException;
import com.sbassement.exception.EmployeeNotFoundException;
import com.sbassement.exception.MandatroyFieldsException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.OK);
	}
	
	@ExceptionHandler(MandatroyFieldsException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(MandatroyFieldsException ex) {
		return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.OK);
	}
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<String> employeeAlreadyExecption(EmployeeAlreadyExistsException ex) {
		return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.OK);
	}


	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> allExeptionHandler(Throwable ex) {
		return new ResponseEntity<>("Exception occured while processing the request", HttpStatus.OK);
	}

}
