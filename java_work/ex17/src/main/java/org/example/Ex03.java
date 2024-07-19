package org.example;

import org.example.phone.MobilePhone;
import org.example.phone.SmartPhone;

public class Ex03 {

    // 부모클래스에 있는 메소드는 상속되며
    // 자식클래스에 동일한 이름에 메소드가 있으면
    // 오버라이딩(재정의) 된다

    // 일부러.. 신입면접개발자...
    // 라이브러리 프레임워크...????
    // 오버플러우... 오버로딩... 오버라이딩... ???
    // 자바 공부... -> 면접.. C 언어 손코딩..
    public static void main(String[] args) {
        MobilePhone mobilePhone =  new SmartPhone("6.0",12345678);
        mobilePhone.show();
    }
}
