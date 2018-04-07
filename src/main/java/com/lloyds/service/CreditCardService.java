package com.lloyds.service;

import com.lloyds.pojos.ChargeCredit;
import com.lloyds.pojos.ChargeCreditClient;
import com.lloyds.pojos.CreditCardDetailsClient;
import com.lloyds.pojos.CreditCardInfo;

public interface CreditCardService {

	public CreditCardInfo createCreditCard(CreditCardDetailsClient cardDetails);
	public ChargeCreditClient charge(ChargeCredit charge);
	public ChargeCreditClient credit(ChargeCredit credit);
}
