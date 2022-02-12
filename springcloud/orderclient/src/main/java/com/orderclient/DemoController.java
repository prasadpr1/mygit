package com.orderclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("welcome")
	public String welcome() {
		return restTemplate.getForEntity("http://orderservice/welcome", String.class).getBody();
	}
}
