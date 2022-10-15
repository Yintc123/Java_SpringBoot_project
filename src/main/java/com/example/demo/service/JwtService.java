package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.demo.AuthRequest;

public class JwtService {
	
	// 注入 AuthenticationManager 元件
	@Autowired
    private AuthenticationManager authenticationManager;
	
	// 宣告一個方法，它會驗證傳入的使用者帳密，通過後產生期限2分鐘的 JWT
    public String generateToken(AuthRequest request) {
        // TODO
        return null;
    }
}
