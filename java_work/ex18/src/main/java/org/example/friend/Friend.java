package org.example.friend;

import lombok.ToString;

/*
배열에서...
    클래스 다형성 문법으로
    Friend 클래스 배열로 친구관리를 할 수 있는 프로그램
    부모참조변수는 자식인스턴스를 참조할 수 있다.

    Object obj = new String();
    Object aa = new A();
오버라이드
    @Override 부모클래스에서 존재하는 메서드를 재정의 할때만 사용할 수 있음. <생략가능>
                           존재하지 않는 메서드에 @Override 적으면 에러...
    toString 메서드...

    final 은
    변수.. 상수..
    메서드.. 오버라이드 불가
    클래스.. 상속불가
 */

@ToString
public class Friend extends Object{
    String name;
    String phone;

    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public void showInfo(){
        System.out.println("이름 = "+name);
        System.out.println("연락처 = "+phone);
    }




}
