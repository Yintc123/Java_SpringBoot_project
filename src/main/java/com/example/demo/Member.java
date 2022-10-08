package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//
@Entity // 以class名稱創一張表
@Table(name="members")
public class Member {
	@Id // 主鍵 (Primary Key)
	@GeneratedValue( strategy = GenerationType.IDENTITY) // id編號自動增加 (auto_increment)
	private Long id;
	
	@Column(nullable=false, length=40)
	private String name;
	
	@Column(unique=true, nullable=false, length=40)
	private String email;
	
	@Column(nullable=false, length=40)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Member() {}
	
	public Member(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Member(String name, String email, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role=role;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	
//	public void setId(Long id) {
//		this.id = id;
//	}
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
