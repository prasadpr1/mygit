package com.profiling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilingController {

	@Value("${welcome.message}")
	public String welcomeMsg;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ServiceProperties properties;
	
	@GetMapping("/welcome")
	public String welcome() {
		dataSource.get();
		System.out.println(properties);
		return welcomeMsg;
	}
}
