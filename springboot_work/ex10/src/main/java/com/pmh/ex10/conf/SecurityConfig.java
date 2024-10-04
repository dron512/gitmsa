package com.pmh.ex10.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf( csrf -> csrf.disable() );
        http.formLogin( form -> form.disable());
        http.httpBasic( basic -> basic.disable());

        http.authorizeRequests( auth -> auth
                // 일반 사용자도 접근 가능하다
                .requestMatchers( "/login", "/join", "/", "/freeboard/**","/user/**" ).permitAll()
                // AMDIN 으로 role 을 가지고 있을때 접근 가능 하다.
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated() );

        http.sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ));

        return http.build();
    }

}
