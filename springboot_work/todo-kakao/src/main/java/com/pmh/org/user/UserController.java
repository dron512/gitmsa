package com.pmh.org.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

//    @GetMapping("info")
//    public ResponseEntity<UserDto> getUserInfo(
////            @RequestHeader("Authorization") String token,
//            @AuthenticationPrincipal UserDetails userDetails){
//
//    }

}
