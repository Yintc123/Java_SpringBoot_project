package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberUserDetailsService implements UserDetailsService {

	// UserDetailsService載入使用者資訊的一個組件，實作使用者登入驗證邏輯
	// https://www.youtube.com/watch?v=n2sH5-Vko1M
	
	@Autowired
	private MemberRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//查詢使用者資訊UserDetails，然後比對使用者資訊與輸入的密碼是否相同來驗證是否為合法的使用者
		
		Member user = repo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("No user found for the given Email");
		}
		
		return new MemberUserDetails(user);
	}

}
