package com.example.startProject.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.startProject.service.PaymemtService;

@Service("PaymentService2Impl")
public class PaymentService2Impl implements PaymemtService {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentService2Impl.class);

	
	@Override
	public void printMessage() {
		logger.info("In PaymentService2Impl");
	}

}
