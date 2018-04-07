package com.lloyds.service;

import java.text.DecimalFormat;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lloyds.entities.CreditCardDetails;
import com.lloyds.pojos.ChargeCredit;
import com.lloyds.pojos.ChargeCreditClient;
import com.lloyds.pojos.CreditCardDetailsClient;
import com.lloyds.pojos.CreditCardInfo;
import com.lloyds.repositories.CreditCardRepository;
import com.lloyds.userExceptions.RecordNotFoundException;
import com.lloyds.util.CreditCardNumberValidator;
@Service
public class DefaultCreditCardService implements CreditCardService{
	
	@Autowired(required=true)
	CreditCardRepository ccRepo;
	
	public CreditCardInfo createCreditCard(CreditCardDetailsClient cardDetails) {
		CreditCardNumberValidator.validate(cardDetails.getNumber());
		CreditCardDetails details = creditCardDetailsMapper(cardDetails);
		ccRepo.save(details);
		return creditCardInfoMapper(details);
	}
	
	@Transactional
	public ChargeCreditClient charge(ChargeCredit charge) {
		CreditCardNumberValidator.validate(charge.getNumber());
		Long cardNumber = Long.parseLong(charge.getNumber());
		CreditCardDetails details = ccRepo.findByNumber(cardNumber);
		if(details == null) {
			throw new RecordNotFoundException("Records Not Found");
		}
		double bal = details.getBal();
		if(charge.getAmount() + bal > details.getLimit() ) {
			return new ChargeCreditClient(cardNumber, convertAmountToString(details.getBal()));
		}
		details.setBal(bal+charge.getAmount());
		return new ChargeCreditClient(cardNumber, convertAmountToString(details.getBal()));
	}
	
	@Transactional
	public ChargeCreditClient credit(ChargeCredit credit) {
		CreditCardNumberValidator.validate(credit.getNumber());
		Long cardNumber = Long.parseLong(credit.getNumber());
		CreditCardDetails details = ccRepo.findByNumber(cardNumber);
		double currentBal = details.getBal();
		details.setBal(currentBal-credit.getAmount());
		return new ChargeCreditClient(cardNumber, convertAmountToString(details.getBal()));
	}
	
	private String convertAmountToString(Double amount) {
		String remainingBalString = new DecimalFormat("###.##").format(amount);
		return "£"+remainingBalString;
	}
	
	private CreditCardDetails creditCardDetailsMapper(CreditCardDetailsClient clientObj) {
		CreditCardDetails details = new CreditCardDetails();
		
		//New account starts with 0 balance.
		details.setBal(0l);
		
		details.setLimit(clientObj.getLimit());
		details.setName(clientObj.getName());
		details.setNumber(Long.parseLong(clientObj.getNumber()));
		return details;
	}
	
	private CreditCardInfo creditCardInfoMapper(CreditCardDetails details) {
		CreditCardInfo info = new CreditCardInfo();
		info.setBal(convertAmountToString(details.getBal()));
		info.setLimit(convertAmountToString(details.getLimit()));
		info.setName(details.getName());
		info.setNumber(details.getNumber());
		return info;
	}
}
