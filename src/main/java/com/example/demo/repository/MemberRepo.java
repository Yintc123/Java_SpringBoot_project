package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	
	public Member findByEmail(String email);
//	
//	public List<Member> findByEmail(String email);
}
