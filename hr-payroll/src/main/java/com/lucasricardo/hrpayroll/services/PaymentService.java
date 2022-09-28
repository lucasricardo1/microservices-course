package com.lucasricardo.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lucasricardo.hrpayroll.entities.Payment;
import com.lucasricardo.hrpayroll.entities.Worker;
import com.lucasricardo.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, Integer days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getdailyIncome(), days);
		
	}

}
