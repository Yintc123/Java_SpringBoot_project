package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepo;

@Configuration
public class DatabaseLoader {
	
	private MemberRepo repo;
	
	public DatabaseLoader(MemberRepo repo) {
		this.repo=repo;
	}
	
//	@Bean
//	public CommandLineRunner initializeDatabase() {
//		return args -> {
//			Member user1=new Member("test", "123@123", "123", Role.ADIMIN);
//			Member user2=new Member("hello", "456@456", "456", Role.ADIMIN);
//			Member user3=new Member("Lin", "qaz@qaz", "qaz", Role.ADIMIN);
//			
//			repo.saveAll(List.of(user1, user2, user3));
//			System.out.println("Database initialized");
//		};
//	}
}
