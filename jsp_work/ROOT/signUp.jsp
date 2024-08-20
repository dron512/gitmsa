<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%
    // 주소줄에 있는 email password 가져오는 방법
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    out.println("email = "+ email);
    out.println("password = "+ password);

    Connection conn = null;
    PreparedStatement pstmt = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://192.168.0.29:3307/pmh",
                                            "root",
                                            "1234");
        pstmt = conn.prepareStatement("INSERT INTO member (email,password) VALUES (?,?)");
        pstmt.setString(1,email);
        pstmt.setString(2,password);
        pstmt.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
    finally{

    }

// insert 완료 하고 나서 login.jsp 가라...
    response.sendRedirect("login.jsp?aa=bb");

%>