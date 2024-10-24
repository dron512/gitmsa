package com.pmh.org.kakao.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class KakaoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String userId;
    private String nickname;
    private String profile_image;
    private String thumbnail_image;
    private String email;

    @JsonIgnore
    private String access_token;
    @JsonIgnore
    private String token_type;
    @JsonIgnore
    private String refresh_token;
    @JsonIgnore
    private String expires_in;
    @JsonIgnore
    private String scope;
    @JsonIgnore
    private String refresh_token_expires_in;
}
