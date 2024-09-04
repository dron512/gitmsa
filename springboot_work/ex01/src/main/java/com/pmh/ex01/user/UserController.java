package com.pmh.ex01.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class UserController {

    @GetMapping("aa")
    public String aa(){
        LocalDateTime mydate = LocalDateTime.now();
        try( Connection conn
                     = DriverManager.getConnection(
                "jdbc:mysql://192.168.0.29:3307/pmh","root","1234") ){
            PreparedStatement pstmt
                    = conn.prepareStatement("""
                        INSERT INTO member 
                            (NAME,age,email,password,mydate)
                        values
                            (?,?,?,?,?)
                    """);
            pstmt.setString(1,"홍길동");
            pstmt.setInt(2,30);
            pstmt.setString(3,"aaaa@naver.com");
            pstmt.setString(4,"password");
            pstmt.setObject(5, mydate);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "memberTable 저장했습니다.";
    }

    @GetMapping("bb")
    public String bb(){
        return "bb";
    }

}
