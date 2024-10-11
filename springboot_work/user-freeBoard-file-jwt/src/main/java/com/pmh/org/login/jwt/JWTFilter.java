package com.pmh.org.login.jwt;

import com.pmh.org.login.LoginUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTManager jwtManager;

    public JWTFilter(JWTManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("지나간다...");
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(auth == null || !auth.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = auth.split(" ")[1];
            Jws<Claims> claims = jwtManager.getClaims(token);
            String email = claims.getPayload().get("email").toString();
            String role = claims.getPayload().get("role").toString();
            LoginUserDetails loginUserDetails = new LoginUserDetails(email,
                                                                    null,
                                                                    role);
            Authentication authentication
                    = new UsernamePasswordAuthenticationToken(
                    loginUserDetails, null,
                    loginUserDetails.getAuthorities()
            );
            // 로그인설정
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(request,response);
    }
}
