package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.springframework.security.config.Customizer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.ldap.EmbeddedLdapServerContextSourceFactoryBean;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.example.demo.service.MemberUserDetailsService;

//https://www.youtube.com/watch?v=ErwPP7xLwDY
//若要自定義登入邏輯需繼承WebSecurityConfiguration
@Configuration // 專門讀取環境參數的類別
@EnableWebSecurity // 啟用Spring Security所需的各項配置
@Order(1) // 設定spring boot容器加載的順序
public class SecurityConfig {
	
	// 將回傳的method建立成元件
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		https
			.csrf().disable() // 跨站請求偽造 (Cross-site request forgery)，利用cookie帶的使用者使用者狀態攻擊
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").authenticated()
				.antMatchers(HttpMethod.GET).permitAll()
				.antMatchers(HttpMethod.POST, "/api/member").permitAll()
                .antMatchers(HttpMethod.PATCH, "/api/member").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
//				.loginPage("https://springbootpractice.yin888.info/login").permitAll()
				.loginPage("/login").permitAll()
				.usernameParameter("email")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
//				.logoutSuccessUrl("https://springbootpractice.yin888.info/login")
				.logoutSuccessUrl("/login")
				.permitAll();
		
	        return https.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MemberUserDetailsService();
	}
	
	// 一定要透過 @bean 注入密碼演算的實例
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
	}
	
}
