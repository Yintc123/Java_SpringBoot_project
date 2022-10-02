package com.example.demo;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebserviceController {
	
	@GetMapping("/rest")
	public String restHello() {
		return "Hello rest";
	}
	
//	@PostMapping("/member")
//	public Map<String, Object> member(@RequestParam String account, @RequestParam String password) {
//		Map<String, Object> data = new HashMap<>();
//		System.out.println("post method");
//		System.out.println(account);
//		System.out.println(password);
//		data.put("a", "10");
//        data.put("b", 20);
//        data.put("c", new String[] {"foo", "orz"});
//        data.put("d", new Date(0));
//        return data;
//	}
	
	@PostMapping("/member")
	public Member member(@RequestParam String account, @RequestParam String password) {
		Member user = new Member();
		System.out.println("post method");
		System.out.println(account);
		System.out.println(password);
		user.setName("yin");
		user.setEmail("test");
		user.setId((long) 100);
		user.setPassword("test");
        return user;
	}
}
