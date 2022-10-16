// reference
// https://chikuwa-tech-study.blogspot.com/2021/06/spring-boot-username-password-authentication-and-jwt.html

package com.example.demo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.AuthRequest;
import com.example.demo.service.JwtService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
	
	@Autowired
    private JwtService jwtService;
	
//	//POST請求，顯示token
//	@PostMapping
//    public ResponseEntity<Map<String, Object>> issueToken(@Valid @RequestBody AuthRequest request) {
//        
//		System.out.println(request.getUsername());
//		System.out.println(request.getPassword());
//		String token = jwtService.generateToken(request);
//        Map<String, Object> response = Collections.singletonMap("token", "Bearer " + token);
//        System.out.println(response);
//        
//        return ResponseEntity.ok(response);
//    }
	
	//POST請求，解析token
	@PostMapping("/parse")
    public ResponseEntity<Map<String, Object>> parseToken(@RequestBody Map<String, String> request) {
        
		System.out.println("controller parse token");
		String token = request.get("token");
        Map<String, Object> response = jwtService.parseToken(token);

        return ResponseEntity.ok(response);
    }
	
	//POST請求，顯示token
	@PostMapping
    public ResponseEntity<?> issueToken(@Valid @RequestBody AuthRequest request) {
        
		System.out.println("generate jwt");
		ResponseCookie token = jwtService.generateJwtCookie(request);
//        Map<String, Object> response = Collections.singletonMap("token", "Bearer " + token);
//        System.out.println(response);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, token.toString())
                .body("issueToken");
    }
	
}
