package org.example;

import org.example.test.*;

public class Ex02 {
    // 부모클래스에 자식클래스를 담을 수 있다.
    // 자식클래스 생성했을때 부모클래스로 참조 할 수 있다.
    // 클래스 다형성
    public static void main(String[] args) {
        BB[] bary = new BB[10];
        CC[] cary = new CC[10];

        AA[] aary1 = new BB[10];
        AA[] aary2 = new CC[10];

        AA a1 = new BB();
        AA a2 = new CC();

//        BB bb = new AA();

        a1.bb();
        a2.cc();


    }
}
