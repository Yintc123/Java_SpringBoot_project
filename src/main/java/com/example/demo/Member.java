package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 以class名稱創一張表
public class Member {
	@Id // 主鍵 (Primary Key)
	@GeneratedValue( strategy = GenerationType.IDENTITY) // id編號自動增加 (auto_increment)
	private Long id;
	private String name;
	@Column(unique=true)
	private String email;
	private String password;
	public Long getId() {
		return id;
	}
//	public Member(String name, String email, String password) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.password = password;
//	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
