package com.pmh.org.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTManager {


    // JWT 생성
    public String createJWT(String secrekey){
        String jwt = Jwts.builder()
                .claim("email","aaa@naver.com")
                .claim("role","ADMIN")
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                                Base64.getEncoder().encodeToString(secrekey.getBytes()))
                .compact();
        return jwt;
    }

    // JWT 유효한지 검사 .... 우리가 설정한 비밀번호까지...
    public String validJWT(String jwt){
        try {
            SecretKey secretKey
                    = new SecretKeySpec("틀린 비밀번호".getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "test";
    }
}
