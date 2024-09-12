package com.pmh.ex07.freeboard;

import com.pmh.ex07.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// alt + 1 경로 선택..
// esc 소스 작업환경으로..

@SpringBootTest
class FreeBoardRepositoryTest {

    // 스프링 객체 담는 통에서.... freeboardRepository 객체 가져오기
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Test
    void insertTest() {
        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("aaa@naver.com")
                .password("password")
                .build();

        FreeBoard freeBoard = FreeBoard.builder()
                .title("제목")
                .content("내용")
                .user(user)
                .build();
        freeBoardRepository.save(freeBoard);
    }

    @Test
    void selectTest() {
        freeBoardRepository.findAll();
    }
}