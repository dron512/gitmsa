package org.example.aa;

import org.example.Main;

// 기본생성자는 다른생성자를 선언하게 되면 생략 불가

// 상속관계에서는 부모클래스 생성자는 무조건적으로 호출 되어져야 한다.. 기본생성자 다른생성자든..

// 상속관계에서는 부모 클래스 기본생성자를 호출하는게 있는데 <- 이거 생략되어져 있습니다.
// 만약에 부모클래스에 기본생성자가 선언되어져 있지 않을 떄에는... <- 다른생성자 호출을 통해 부모클래스 생성자 호출할 수 있다.

public class FriendMan extends Man {
    private String place;

    public FriendMan(String name){
        super(name);
    }
}
