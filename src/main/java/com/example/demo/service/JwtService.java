package com.example.demo.service;

import java.security.Key;
//import java.security.Key;
import java.util.Calendar;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.MemberUserDetails;
import com.example.demo.auth.AuthRequest;
import com.example.demo.exception.UnprocessableEntityException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	// 注入 AuthenticationManager 元件
	@Autowired
    private AuthenticationManager authenticationManager;
	
	// 設定jwt加密的金鑰
	private final String KEY = "ItsAnImportantJwtKeyForWebsite_Yin888.info";
	
	public ResponseCookie generateJwtCookie(AuthRequest request) {
	    String jwt = generateToken(request);   
	    return generateCookie("jwtCookieName", jwt, "/");
	  }
	
	// 宣告一個方法，它會驗證傳入的使用者帳密，通過後產生期限2分鐘的 JWT
    public String generateToken(AuthRequest request) {
        
    	// 以帳密的方式來驗證，使用 UsernamePasswordAuthenticationToken
    	Authentication authentication = 
    			new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authentication = authenticationManager.authenticate(authentication);
        // UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        MemberUserDetails userDetails = (MemberUserDetails) authentication.getPrincipal();
    	
        // 設定jwt過期時間（2分鐘到期）
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 2);
        System.out.println(calendar.getTime());
        
        // 設定 jwt 的 payload
        Claims claims = Jwts.claims();
        claims.put("username", userDetails.getUsername());
        claims.setExpiration(calendar.getTime());
        claims.setIssuer("OnlyForWebsite_yin888.info");
        
        Key secretKey = Keys.hmacShaKeyFor(KEY.getBytes());
        System.out.println("JwtService got called");
        
    	return Jwts.builder()
    			.setClaims(claims) // payload
    			.signWith(secretKey) // 數位簽章
    			.compact();
    }
    
    // 解析JWT
    public Map<String, Object> parseToken(String token) {
    	
    	System.out.println("parseToken got called");
    	System.out.println("token："+token);
        Key secretKey = Keys.hmacShaKeyFor(KEY.getBytes());

        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build();
        
        try {
        // jwt 過期會導致錯誤
        Claims claims = parser
                .parseClaimsJws(token)
                .getBody();
        return claims.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }catch(ExpiredJwtException e) {
        	System.out.println("token got expired");
        	getCleanJwtCookie();
        	Claims claims = e.getClaims();
        	return claims.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        
    }
    
    
    public boolean validateJwtToken(String token) {
    	Key secretKey = Keys.hmacShaKeyFor(KEY.getBytes());
        try {
          Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
          return true;
        } catch (Exception e) {
        	new UnprocessableEntityException(e.getMessage());
        }

        return false;
      }
    
    private ResponseCookie generateCookie(String name, String value, String path) {
        ResponseCookie cookie = ResponseCookie.from(name, value).path(path).maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
      }
    
    public ResponseCookie getCleanJwtCookie() {
    	System.out.println("cleanCookie");
        ResponseCookie cookie = ResponseCookie.from("jwtCookieName", null).path("/api").build();
        return cookie;
      }
    
    
}
