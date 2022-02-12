package com.orderservice;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	public static Date date = new Date();
	
	@GetMapping("/welcome")
	public String demo() {
		return "Date is :"+date;
	}
}
