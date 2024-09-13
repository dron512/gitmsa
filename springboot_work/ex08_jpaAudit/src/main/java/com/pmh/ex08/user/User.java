package com.pmh.ex08.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT 이거 설정해줘...
    private Long idx;

    @Column(name = "username",nullable = false,length = 50)
    private String name;

    private int age;

    @Column(length = 100, unique = true)
    @Email
    private String email;

    @Column(length = 100)
    private String password;

    private LocalDateTime wdate;

}