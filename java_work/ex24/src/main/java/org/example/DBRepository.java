package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBRepository {
    /*
        1. Class.forname jar 파일 추가 확인
        2. Connection DB연결
        3. PrepareStatement sql구문작성
        4. sql구문 실행
        executeUpdate(); -> insert,update,delete,create,alter 문 실행할떄
        executeQuery(); -> select 문 실행할떄
     */
    public void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // DB 연결
            conn =  DriverManager.getConnection(
                            "jdbc:mysql://192.168.0.29:3307/pmh",
                            "root",
                            "1234");
            //sql 생성
            pstmt = conn.prepareStatement("INSERT INTO member (name,age) VALUES (?,?)");
            String name = JOptionPane.showInputDialog("이름");
            pstmt.setString(1,name);
            int age = Integer.parseInt( JOptionPane.showInputDialog("나이") );
            pstmt.setInt(2,age);

            // sql구문 실행
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            }catch (Exception e){}
        }
    }

    public void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // DB 연결
            conn =  DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.29:3307/pmh",
                    "root",
                    "1234");
            //sql 생성
            pstmt = conn.prepareStatement("DELETE FROM member where idx = ?");

            int idx = Integer.parseInt( JOptionPane.showInputDialog("idx") );
            pstmt.setInt(1,idx);

            // sql구문 실행
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            }catch (Exception e){}
        }
    }

}
