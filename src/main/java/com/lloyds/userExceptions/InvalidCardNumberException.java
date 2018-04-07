package com.lloyds.userExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class InvalidCardNumberException extends RuntimeException{

	public InvalidCardNumberException(String message) {
		super(message);
	}
}
