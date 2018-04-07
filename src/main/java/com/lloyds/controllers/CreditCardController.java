package com.lloyds.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lloyds.pojos.ChargeCredit;
import com.lloyds.pojos.ChargeCreditClient;
import com.lloyds.pojos.CreditCardDetailsClient;
import com.lloyds.pojos.CreditCardInfo;
import com.lloyds.service.CreditCardService;

@RestController
@RequestMapping("creditCardProcessing")
public class CreditCardController {

	@Autowired
	CreditCardService cardService;
	
	@PutMapping("/add")
	public ResponseEntity<CreditCardInfo> add(@Valid @RequestBody CreditCardDetailsClient card) {
			CreditCardInfo details = cardService.createCreditCard(card);
		 return new ResponseEntity<CreditCardInfo>(details,HttpStatus.CREATED);
	}
	
	@PostMapping("/charge")
	public ResponseEntity<ChargeCreditClient> charge(@Valid @RequestBody ChargeCredit card) {
		return new ResponseEntity<ChargeCreditClient>(cardService.charge(card), HttpStatus.OK);
	}
	
	@PostMapping("/credit")
	public ResponseEntity<ChargeCreditClient> credit(@Valid @RequestBody ChargeCredit card) {
		return new ResponseEntity<ChargeCreditClient>(cardService.credit(card), HttpStatus.OK);
	}
	
}
