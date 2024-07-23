package org.example;

// alt + 1 <<- 브라우저 경로
// esc 소스로 온다...
// alt + insert 키로 파일 생성
// ctrl + E 파일이동 shift,shift 두번 누르기
// ctrl + / 주석처리
// ctrl + . 접는다..소스 접는 기능

import org.example.inter.Printable;
import org.example.print.LGPrinter;
import org.example.print.SamPrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println(Printable.HEIGHT);
        System.out.println(Printable.WIDTH);

        Printable prn = new LGPrinter();
        prn.print("내 문서");

        prn = new SamPrinter();
        prn.print("내문서");

        // final 예약어 붙어 있어서 값의 변경이 불가능하다...
//        Printable.HEIGHT = 90;

    }
}