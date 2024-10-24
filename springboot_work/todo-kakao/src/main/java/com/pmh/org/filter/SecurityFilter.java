package com.pmh.org.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("Security Filter");
        /*
        프론트 에서 넘겨준
        jwt 토큰 까서...
        UserPasswordAuthenticationToken
        authentication
        securityContext
         */

//        SecurityContextHolder.getContext()
//                .setAuthentication(authentication);

        // 지나가라...
        filterChain.doFilter(request, response);
    }
}
