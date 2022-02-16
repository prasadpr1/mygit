package com.orderclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("http://orderservice")
public interface OrderServiceClient {

	@GetMapping("/welcome")
	public String welcome();
}
