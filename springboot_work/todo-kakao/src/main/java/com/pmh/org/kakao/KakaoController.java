package com.pmh.org.kakao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("kakao")
@Slf4j
public class KakaoController {

    @GetMapping("login")
    public String kakaoCode(@RequestParam String code) {
        log.info("code {}", code);

        // 1. restTemplate
        try {
            String url = "https://kauth.kakao.com/oauth/token";
            RestTemplate restTemplate = new RestTemplate();

            MultiValueMap headers = new LinkedMultiValueMap();
            headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "authorization_code");
            body.add("client_id", "477ea0788a39a67ac40fa6b1bc49e7d8");
            body.add("redirect_uri", "http://localhost:5173/oauth");
            body.add("code", "s6dI4DhhlwyOIswkfw1dU7aji63w8aHS05BHqTJRMBlfUMPYMg32MQAAAAQKPCQhAAABkq2L2-Ip9hBbJybEWQ");
            body.add("client_secret", "TbN9J7UNCPyH9mpkDVFJTyNiY5frkU3y");

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity ,String.class);
            log.info("result {}", result);

//            restTemplate.exchange();

//            {
//            "access_token":"SHsjJCFLY65xOmoR-AGAIiIFhRAJkEPAAAAAAQo8JFkAAAGSrYxAeqQkDeVh20ZZ",
//            "token_type":"bearer",
//            "refresh_token":"K7Lf_iRcMterKs5qpCH7MEwrEXXEvc-qAAAAAgo8JFkAAAGSrYxAeKQkDeVh20ZZ",
//            "expires_in":21599,
//            "scope":"account_email talk_calendar profile_image talk_message talk_calendar_task profile_nickname friends",
//            "refresh_token_expires_in":5183999},
//            [Date:"Mon, 21 Oct 2024 05:28:22 GMT",
//            Content-Type:"application/json;charset=utf-8",
//            Transfer-Encoding:"chunked",
//            Connection:"keep-alive",
//            Cache-Control:"no-cache,
//            no-store, max-age=0,
//            must-revalidate",
//            Pragma:"no-cache",
//            Expires:"0", X-XSS-Protection:"1; mode=block", X-Frame-Options:"DENY",
//            X-Content-Type-Options:"nosniff", Kakao:"Talk", Access-Control-Allow-Origin:"*", Access-Control-Allow-Methods:"GET, POST, OPTIONS", Access-Control-Allow-Headers:"Authorization, KA, Origin, X-Requested-With, Content-Type, Accept"]

        } catch (Exception e) {
            e.printStackTrace();
        }


        // 2. openfeign

        return "kakao code";
    }

}
