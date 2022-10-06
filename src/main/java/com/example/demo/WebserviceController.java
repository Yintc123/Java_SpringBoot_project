package com.example.demo;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@RestController
@RequestMapping("/api")
public class WebserviceController {
	
	@Autowired
	MemberRepo repo;
	
	@Autowired
	MemberService MemberService;
	
	@GetMapping("/rest")
	public String restHello() {
		return "Hello rest";
	}
	
	@PostMapping("/member")
	public ResponseEntity<Map<String, String>> member(@ModelAttribute MemberQueryParameter parameter) {
		
		System.out.println("post method");
		
		Member user = MemberService.checkInputOfRegistration(parameter);
		MemberService.checkAccountExisted(user.getEmail());
		boolean result=MemberService.createMember(user);
		if(result != true) {
			throw new UnprocessableEntityException("error in createMember");
		}
		Map<String, String> resp = new HashMap<>();
		resp.put("ok", "200");
        return ResponseEntity.ok().body(resp);
	}
//	
//	@PatchMapping("/member")
//	public ResponseEntity<Map<String, String>> patchMember(@ModelAttribute MemberQueryParameter parameter) {
//
//		System.out.println("patch method");
//
//		Member user = MemberService.checkInputOfLogin(parameter);
//		boolean result = MemberService.validateUser(parameter);
//		if (result != true) {
//			throw new UnprocessableEntityException("error in validateUser");
//		}
//		Map<String, String> resp = new HashMap<>();
//		resp.put("ok", "200");
//        return ResponseEntity.ok().body(resp);
//	}

	
//	@DeleteMapping("/member")
//	public Member deleteMember(@RequestParam String account, @RequestParam String password) {
//		Member user = new Member();
//		System.out.println("delete method");
//		System.out.println(account);
//		System.out.println(password);
//		user.setName("yin");
//		user.setEmail("delete");
//		user.setPassword("del_test");
//        return user;
//	}
}
