package com.pmh.ex05.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

// 프론트 오는 파라메타의 검사..
@Data
public class UserReqDto {

    private Long idx;

    private String name;
    private int age;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    private LocalDateTime wdate;

}
