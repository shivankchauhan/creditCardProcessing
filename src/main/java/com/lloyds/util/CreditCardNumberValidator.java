package com.lloyds.util;

import com.lloyds.userExceptions.InvalidCardNumberException;

public class CreditCardNumberValidator {
	
	public static void validate(String number) {
		if(number.length() > 17) 
			throw new InvalidCardNumberException("Card number Max Length Exceeded.");
		
		if(!LuhnValidation.validate(number)) {
			throw new InvalidCardNumberException("Invalid Card number.");
		}
		
		try {
			Long.parseLong(number);
		} catch( NumberFormatException e) {
			throw new InvalidCardNumberException("Card Number can only be numeric");
		}
	}

}
