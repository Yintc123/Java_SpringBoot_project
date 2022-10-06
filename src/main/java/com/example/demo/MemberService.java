package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class MemberService {
	
	@Autowired
	MemberRepo repo;
	
//	private Member member;
	
	public Member checkInputOfRegistration(@ModelAttribute MemberQueryParameter parameter) {
		
		String name=parameter.getName();
		String account=parameter.getAccount();
		String password=parameter.getPassword();
		
		if(name.isEmpty()) { // == "" 和 == null，皆為false
			throw new UnprocessableEntityException("name is null");
		}
		if(account.isEmpty()) {
			throw new UnprocessableEntityException("email is null");
		}
		if(password.isEmpty()) {
			throw new UnprocessableEntityException("password is null");
		}
		
		Member user = new Member(name, account, password, Role.ADIMIN);
		
		return user;
	}
	
	public Member checkInputOfLogin(@ModelAttribute MemberQueryParameter parameter) {
		
		String account=parameter.getAccount();
		String password=parameter.getPassword();
		
		if(account.isEmpty()) {
			throw new UnprocessableEntityException("email is null");
		}
		if(password.isEmpty()) {
			throw new UnprocessableEntityException("password is null");
		}
		
		Member user = new Member(account, password, Role.ADIMIN);
		
		return user;
	}
	
	public Member checkAccountExisted(String account) {
		
		Member checked_user = repo.findByEmail(account);
		if(checked_user != null) {
			throw new UnprocessableEntityException("email was registered");
		}
		System.out.println("email沒被註冊過");
		return checked_user;
	}
	
	public boolean validateUser(@ModelAttribute MemberQueryParameter parameter) {
		
		Member user = repo.findByEmail(parameter.getAccount());
		if(user == null) {
			throw new UnprocessableEntityException("email isn't registered");
		}
		if(! user.getPassword().equals(parameter.getPassword())) {
			throw new UnprocessableEntityException("password is wrong");
		}
		return true;
	}
	
	public boolean createMember(Member user) {
		
		repo.save(user);
		return true;
	}
}
