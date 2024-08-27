package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDBRespository {

    public List<Member> select(){
        List<Member> list = new ArrayList<>();
        Connection conn = null; // DB연결 객체
        PreparedStatement pstmt = null; // sql작성 객체
        ResultSet rs = null;    // select 문 테이블 담는 객체
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");   // jar 파일 추가 되어 있는지 확인
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.29:3307/pmh",
                    "root",
                    "1234");    // DB 연결
            pstmt = conn.prepareStatement("select * from member");  //sql 구문 작성
            rs = pstmt.executeQuery();    //sql 구문 실행
            while(rs.next()){
                Member member = new Member(
                        rs.getInt("idx"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                list.add(member);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
        }
        return list;
    }
}
