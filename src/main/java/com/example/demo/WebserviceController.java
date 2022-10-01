package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebserviceController {
	
	@GetMapping("/rest")
	public String restHello() {
		return "Hello rest";
	}
}
