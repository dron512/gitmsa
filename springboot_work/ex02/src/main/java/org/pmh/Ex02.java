package org.pmh;

import org.pmh.components.CC;

public class Ex02 {

    // 싱글톤...
    public static void main(String[] args) {

//        CC cc = new CC();

        // 이걸로 객체 생성해라...
        CC cc1= CC.getInstance();
        System.out.println(cc1);

        CC cc2= CC.getInstance();
        System.out.println(cc2);

        CC cc3 = new CC();

        System.out.println(cc1==cc2);

        System.out.println(cc1==cc3);

    }
}
