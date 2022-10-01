package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebserviceController {
	
	@GetMapping("/rest")
	public String restHello() {
		return "Hello rest";
	}
	
	@PostMapping("/member")
	public String member() {
		System.out.print("post method");
		return "123";
	}
}
