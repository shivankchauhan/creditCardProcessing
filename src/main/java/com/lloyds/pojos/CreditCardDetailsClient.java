package com.lloyds.pojos;

import java.io.Serializable;

public class CreditCardDetailsClient implements Serializable{
	private static final long serialVersionUID = 1L;

	//@NotBlank
	private String name;

	//@NotBlank
	private String number;
	
	private double limit;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}

