package com.pmh.org.jwt;

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
import org.springframework.security.core.userdetails.UserDetails;
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

        // Todo...
        // front에서 freeboard 요청할떄 JWT 검사 해야함
        // front에서 join 할떄 jwt 요청하면 문제가 생김
        
        String token = auth.split(" ")[1];

        Jws<Claims> claims = jwtManager.getClaims(token);
        String email = claims.getPayload().get("email").toString();
//        String role = "ADMIN";
        String role = claims.getPayload().get("role").toString();

        LoginUserDetails loginUserDetails = new LoginUserDetails(email,null,role);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginUserDetails, null, loginUserDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);
    }
}
