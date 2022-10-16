package com.example.demo.filter;

import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.example.demo.MemberUserDetails;
import com.example.demo.service.JwtService;
import com.example.demo.service.MemberUserDetailsService;

import java.io.IOException;
//import io.jsonwebtoken.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	// 注入 JwtService
	@Autowired
    private JwtService jwtService;
	
	// 注入 MemberUserDetailsService
    @Autowired
    private MemberUserDetailsService memberUserDetailsService;
    
    // 覆寫 doFilterInternal
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        
    	// 每次送出請求皆會跑一次 doFilterInternal，/login葉面跑4次request
    	
    	System.out.println("doFilterInternal got called");
    	
    	// 擷取 request 的 header
//    	String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    	Cookie authHeader = WebUtils.getCookie(request, "jwtCookieName");
    	
    	
    	System.out.println("authHeader："+authHeader);
    	
    	if (authHeader != null) {
    		
    		System.out.println("Cookie：" + authHeader.getValue());
    		String jwt=authHeader.getValue();
    		// request 有 header 
    		// 使用 "" 取代字串 "Bearer "，Bearer 被定義在 Header 中的驗證方案，通常搭配於 JWT
            String accessToken = jwt.replace("Bearer ", "");
            
            boolean isValid=jwtService.validateJwtToken(accessToken);
            
            if(isValid==true) {
            
            System.out.println("is valid");
            //取出 payload
            Map<String, Object> claims = jwtService.parseToken(accessToken);
            
            System.out.println(claims.get("username"));
            //取出帳號
            String account = (String) claims.get("username");
            MemberUserDetails userDetails = memberUserDetailsService.loadUserByUsername(account);

            // 將這個請求的使用者身份告訴伺服器建立 UsernamePasswordAuthenticationToken 物件
            // 其建構子的第一個參數接受（principal），傳入使用者詳情（UserDetails）
            // 其建構子的第二個參數接受 credentials，通常是指密碼，不傳也無妨。經由傳入 principal，得以在業務邏輯中從 Context 獲取使用者身份的資料
            // 其建構子的第三個參數接受 GrantedAuthority 的 List，會作為 API 授權檢查之用
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            
            // 將該次請求所代表的驗證後資料（Authentication）帶進 Security 的「Context」，
            // Context 是一種較抽象的概念，可以想像成該次請求的身份狀態
            SecurityContextHolder.getContext().setAuthentication(authentication);
            }else{
            	System.out.println("is invalid");
//            	Authentication authentication =
//                        new UsernamePasswordAuthenticationToken(null, null, null);
//            	SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
    	
    	System.out.println("exit if condition");
    	
    	chain.doFilter(request, response);
    	
    }
    
    
}
