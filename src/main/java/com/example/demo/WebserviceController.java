package com.example.demo;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebserviceController {
	
	@Autowired
	MemberRepo repo;
	
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
	public Map<String, String> member(@RequestParam String name, @RequestParam String account, @RequestParam String password) {
		Member user = new Member();
		System.out.println("post method");
		Map<String, String> resp = new HashMap<>();
		if(name.isEmpty()) { // == "" 和 == null，皆為false
			resp.put("error", "name is null");
			return resp;
		}
		if(account.isEmpty()) {
			resp.put("error", "email is null");
			return resp;
		}
		if(password.isEmpty()) {
			resp.put("error", "password is null");
			return resp;
		}
		user.setName(name);
		user.setEmail(account);
		user.setPassword(password);
		
		Member checked_user = repo.findByEmail(account);
		if(checked_user != null) {
			resp.put("error", "email was registered");
			return resp;
		}
		System.out.println("email沒被註冊過");
		repo.save(user);
		resp.put("ok", "200");
        return resp;
	}
	
	@PatchMapping("/member")
	public Map<String, String> patchMember(@RequestParam("account") String account, @RequestParam("password") String password) {
		Member user = new Member();
		System.out.println("patch method");
		Map<String, String> resp = new HashMap<>();
		if(account.isEmpty()) { // == "" 和 == null，皆為false
			resp.put("error", "email is null");
			return resp;
		}
		if(password.isEmpty()) {
			resp.put("error", "password is null");
			return resp;
		}
		user.setEmail(account);
		user.setPassword(password);
		List<Member> dataList=repo.findAll();
		System.out.println(dataList.get(0).getName());
		Member member = repo.findByEmail(account);
		if(member == null) {
			resp.put("error", "email isn't registered");
			return resp;
		}
		if("123" == member.getPassword()) {
			System.out.println("member.getPassword()");
		}
		if("123" == user.getPassword()) {
			System.out.println("user.getPassword()");
		}
		System.out.println(member.getPassword());
		System.out.println();
		if(!user.getPassword().equals(member.getPassword())) { // user.getPassword() == member.getPassword() → false
			resp.put("error", "password is wrong");
			return resp;
		}
		resp.put("ok", "200");
        return resp;
	}
	
	@DeleteMapping("/member")
	public Member deleteMember(@RequestParam String account, @RequestParam String password) {
		Member user = new Member();
		System.out.println("delete method");
		System.out.println(account);
		System.out.println(password);
		user.setName("yin");
		user.setEmail("delete");
		user.setPassword("del_test");
        return user;
	}
	
	
}
