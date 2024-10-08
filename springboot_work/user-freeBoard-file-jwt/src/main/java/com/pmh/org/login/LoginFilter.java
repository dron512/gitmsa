package com.pmh.org.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmh.org.jwt.JWTManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTManager jwtManager;

    public LoginFilter(AuthenticationManager authenticationManager,
                       JWTManager jwtManager) {
        this.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
    }
    // 로그인 시도
    @Override
    public Authentication attemptAuthentication(
                HttpServletRequest request,
                HttpServletResponse response) throws AuthenticationException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email,password);
        return authenticationManager.authenticate(token);
    }

    // 로그인 성공... jwt 토큰발행
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("======================");
        System.out.println(authResult);

        System.out.println(authResult.getPrincipal().toString());
        System.out.println(authResult.getCredentials().toString());
        System.out.println(authResult.getAuthorities().toString());
        System.out.println("======================");

        jwtManager.createJWT();
        response.getWriter().write("success");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
                .write("check email and password");
    }
}
