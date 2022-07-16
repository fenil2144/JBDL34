package com.example.startProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.startProject.model.Demo;
import com.example.startProject.service.PaymemtService;


@RestController
@RequestMapping("/v1")
public class DemoController {	
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	//Field Injection
//	@Autowired
	private Demo demo;
	
	//Constructor Injection
	@Autowired
	public DemoController(Demo demo) {
		this.demo = demo;
		logger.info("Demo : {}",demo.toString());
	}
	
//	@Value("${server.port}")
//	int b;
	
	public DemoController(@Value("${server.port}") int a) {
		logger.info("a = {}",a);
	}
	
	
	@Autowired
	@Qualifier("PaymentService2Impl")
	private PaymemtService paymemtService;
	
	
	//com.example.startProject.model.Demo@59a4e273
	//com.example.startProject.model.Demo@1051b969
	
	//com.example.startProject.model.Demo@2c9f8508
	//com.example.startProject.model.Demo@2c9f8508
	
	@GetMapping("/demo")
	public Demo getDemo(){
//		Demo demo = new Demo();
		logger.info("Demo Object is : {}",demo);
		paymemtService.printMessage();
		return demo;
	}
	
	@PostMapping("/demo")
	public Demo getDemo1(){
//		Demo demo = new Demo();
		logger.info("Demo Object is : {}",demo);
		paymemtService.printMessage();
		return demo;
	}
	
	
	@GetMapping("/requestParam")
	public void requestParamMethod(@RequestParam String name,
			@RequestParam String name1) {
		logger.info("Request Param received with name : {}",name);
	}
	
	@GetMapping("/pathVariable/{id}/addr/{addrId}")
	public void pathVariableMethod(@PathVariable int id) {
		logger.info("Path varaible received with id : {}",id);

	}
	
	@GetMapping("/requestBody")
//	@ResponseBody
	public Demo requestBodyMethod(@RequestBody Demo demoObj) {
		return demoObj;
	}

}
