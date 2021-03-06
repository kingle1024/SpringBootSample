package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TestService;

@RestController
public class TestController {


	private final TestService service;

	@Autowired
	public TestController(TestService service) {
		this.service = service;
	}

	@GetMapping(value = "/noAop")
	public String noAop(){
		return service.test();
	}
	
	@GetMapping(value = "/aop")
	public String aop(){
		return service.testAop();
	}
}
