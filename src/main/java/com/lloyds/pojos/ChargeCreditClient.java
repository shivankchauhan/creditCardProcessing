package com.lloyds.pojos;

public class ChargeCreditClient {
	private Long number;
	private String currentBal;
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public ChargeCreditClient(Long number, String amount) {
		super();
		this.number = number;
		this.currentBal = amount;
	}
	
	public ChargeCreditClient() {
	}
	public String getCurrentBal() {
		return currentBal;
	}
	public void setCurrentBal(String currentBal) {
		this.currentBal = currentBal;
	}
	
}
