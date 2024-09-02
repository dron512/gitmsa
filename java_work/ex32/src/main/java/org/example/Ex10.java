package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex10 {

    private MemberRepository memberRepository =
            new MemberRepository();

    Ex10(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("""
                뭐할래?
                1. select()
                2. insert()
                3. update()
                4. delete()
                """);
            int ra = scanner.nextInt();

            if (ra == 1) {
                memberRepository.select();
            } else if (ra == 2) {
                memberRepository.insert();
            }
            else{
                System.out.println("종료됩니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Ex10();
    }

}
