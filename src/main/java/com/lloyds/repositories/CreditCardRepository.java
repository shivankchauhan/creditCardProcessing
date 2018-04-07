package com.lloyds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lloyds.entities.CreditCardDetails;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardDetails, Long>{

	public CreditCardDetails findByNumber(long cardNumber);
}
