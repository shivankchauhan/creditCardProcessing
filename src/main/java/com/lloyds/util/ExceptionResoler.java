package com.lloyds.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionResoler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {IllegalArgumentException.class})
	public ResponseEntity<Object> handleConstraintViolation(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
