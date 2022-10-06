package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	
	public Member findByEmail(String email);
//	
//	public List<Member> findByEmail(String email);
}
