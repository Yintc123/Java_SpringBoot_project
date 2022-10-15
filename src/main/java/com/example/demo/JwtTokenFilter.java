//package com.example.demo;
//
//import java.io.IOException;
//import java.util.Optional;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.TestingAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//
//public class JwtTokenFilter extends OncePerRequestFilter {
// 
//    @Override
//    protected void doFilterInternal(HttpServletRequest request
//    								, HttpServletResponse response
//    								, FilterChain filterChain)
//            throws ServletException, IOException {
// 
////        Authentication authentication = new TestingAuthenticationToken("principal", "credentials");
////        authentication.setAuthenticated(true);
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//// 
////        filterChain.doFilter(request, response);
//        
//        Optional<DecodedJWT> optionalDecodedJWT = Optional.ofNullable(request.getHeader("authorization"))
//                .filter(s -> s.startsWith("Bearer ")).map(s -> s.substring(7)).map(s -> {
//                    try {
//                        return JWT.decode(s);
//                    } catch (JWTDecodeException ex) {
//                        return null;
//                    }
//                });
// 
//        if (optionalDecodedJWT.isPresent()) {
//            Authentication authentication = new JwtAuthentication(optionalDecodedJWT.get());
// 
//            // 这里可以检查 JWT token 是否過期，issuer 等来設置 setAuthenticated(true/false)
// 
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        } else {
//            SecurityContextHolder.clearContext();
//        }
// 
//        filterChain.doFilter(request, response);
//        
//    }
//       
//}