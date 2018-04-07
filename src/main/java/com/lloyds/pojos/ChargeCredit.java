package com.lloyds.pojos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class ChargeCredit implements Serializable{
	
	@NotBlank
	private String number;
	private double amount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ChargeCredit(String number, double amount) {
		super();
		this.setNumber(number);
		this.amount = amount;
	}
	
	public ChargeCredit() {
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	

}
