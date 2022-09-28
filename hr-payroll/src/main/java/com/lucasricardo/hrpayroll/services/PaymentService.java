package com.lucasricardo.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lucasricardo.hrpayroll.entities.Payment;
import com.lucasricardo.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(
				workerHost + "/workers/{id}",
				Worker.class,
				uriVariables);
		
		return new Payment(worker.getName(), worker.getdailyIncome(), days);
		
	}

}
