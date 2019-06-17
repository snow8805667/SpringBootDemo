package com.fire.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class HelloController {
		@Value("${test.name}")
		private String name;
		@Value("${test.password}")
		private String password;
			@RequestMapping("myfirst")
			public String hello(){
				System.out.println("hello springboot");
				return "myfirst Project"+name+",Greetings from Spring Boot!"+password;
	
		}
			
			
			
			
	}
