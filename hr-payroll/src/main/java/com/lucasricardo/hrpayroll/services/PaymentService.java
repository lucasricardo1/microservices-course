package com.lucasricardo.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.lucasricardo.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}

}
