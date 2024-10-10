package com.pmh.org.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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

        System.out.println("여기를 무조건 지나간다.");

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 인증 토큰인 JWT 가 null 이거나 Bearer 로 시작하는 토큰이 아니면...
        if(auth == null || !auth.startsWith("Bearer ")) {
            // 그냥 지나가라...
            filterChain.doFilter(request, response);
            return;
        }

        // JWT 토큰이 유효한지 확인 해보는 함수
//        jwtManager.validJWT(auth);

        // Bearer asdlckfjnqwlekjcnaslkdcjfnl
        String token = auth.split(" ")[1];

        String email = jwtManager.getEmail(token);
        System.out.println("email = "+email);



        // 여기서 무조건 지나가는
        filterChain.doFilter(request,response);
    }
}
