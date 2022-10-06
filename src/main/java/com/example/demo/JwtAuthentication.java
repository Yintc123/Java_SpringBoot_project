//package com.example.demo;
//
//import java.util.Date;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//public class JwtAuthentication extends AbstractAuthenticationToken {
// 
//    private final DecodedJWT decodedJWT;
// 
//    public JwtAuthentication(DecodedJWT decodedJWT) {
//        super(null);
//        this.decodedJWT = decodedJWT;
//        setAuthenticated(decodedJWT.getExpiresAt().after(new Date()));
//    }
// 
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
// 
//    @Override
//    public Object getPrincipal() {
//        return decodedJWT;
//    }
//}