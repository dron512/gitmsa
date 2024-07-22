package org.example;

import org.example.friend.CompFriend;
import org.example.friend.UniFriend;

import java.util.Arrays;
//class A{
//    public void doA(){}
//}

public class Ex03 {

    public static void main(String[] args) {
//        A a = null;
//        a.doA();
        int ucnt = 0;
        int ccnt = 0;

        // 대학동창
        UniFriend uniFriend[] = new UniFriend[10];
        // 회사동료
        CompFriend cmpFriend[] = new CompFriend[10];

        uniFriend[ucnt++] = new UniFriend("홍길동","010-9900-2600","ㅎㅎ");

        System.out.println(Arrays.toString(uniFriend));
        System.out.println(Arrays.toString(cmpFriend));

        System.out.println("ucnt = "+ucnt);
        for (int i = 0; i < ucnt; i++) {
            uniFriend[i].showInfo();
        }

        for (int i = 0; i < ccnt; i++) {
            cmpFriend[i].showInfo();
        }
    }
}
