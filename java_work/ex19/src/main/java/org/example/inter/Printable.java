package org.example.inter;

public interface Printable {

    // static final 변수를 대문자로 짓는게 관례...

    public static final int HEIGHT = 70;
    int WIDTH = 120;

    void print(String mydoc);

    default void clean(){
        System.out.println("청소기능 추가");
    }

    static void printLine(){
        System.out.println("한줄출력할때 줄바꿈.....");
    }

}
