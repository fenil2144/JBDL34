package com.example.startProject.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.startProject.service.PaymemtService;


@Service("PaymentServiceImpl")
@Primary
public class PaymentServiceImpl implements PaymemtService{

	private static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	
	@Override
	public void printMessage() {
		logger.info("In PaymentServiceImpl");
	}

}
