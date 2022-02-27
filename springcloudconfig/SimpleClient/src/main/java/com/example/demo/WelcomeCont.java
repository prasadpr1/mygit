package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCont {

	@Value("${welcome.msg}")
	public String welcomeMessage;
	
	
	@GetMapping
	public String welcome() {
		return this.welcomeMessage;
	}
}
