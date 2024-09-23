package com.pmh.ex10.freeboard;

import com.pmh.ex10.user.User;
import com.pmh.ex10.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// alt + 1 경로 선택..
// esc 소스 작업환경으로..

@SpringBootTest
class FreeBoardRepositoryTest {

    // 스프링 객체 담는 통에서.... freeboardRepository 객체 가져오기
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    UserRepository userRepository;

    // 1. UserRepository
    // 2. Cascade JPA 속성

//    TransientPropertyValueException
    @Test
//    @Transactional
    void insertTest() {
        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("bbb@naver.com")
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
        List<FreeBoard> list = freeBoardRepository.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void deleteTest(){
        freeBoardRepository.deleteById(5l);
    }

    @Test
    void updateTest(){
        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("bbb@naver.com")
                .password("password")
                .build();

        FreeBoard freeBoard = FreeBoard.builder()
                .idx(4l)
                .title("제목")
                .content("내용")
                .user(user)
                .build();
        freeBoardRepository.save(freeBoard);
    }

}