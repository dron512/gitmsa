package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
    /*
    interface
    변수..public static final 안적어도 됨...
    int A
    몸체가 없는 메서드...public 안적어도...됨...
    void doA();

    class 만들어서 interface 상속 받아야 됨...
    doA() 메서드 재정의...

    default() static() 추가 가능하다...
    메서드 안에 내용이 존재할수 있음..

    default() -> new .... 사용해는 되는 것...
    static() -> Printable.doA();

    람다 규칙은...
    interface 하나의 추상메서드가 존재 해야한다...
    ()->{}

    도커 데스크탑..
    데이터베이스... 우효림...
    MYSQL 서버 설치...

    가상 OS
    docker run 명령어 설치...

    java언어 접속...
    heidisql 클라이언트

    try{} catch구문이 ... 필요하기..

    18장...
    try{} catch{} 예외상황에 대해서 ... 학습중..
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("a : ");
            int a = scan.nextInt();
            System.out.println("b : ");
            int b = scan.nextInt();

            System.out.println("나누기 시작");
            System.out.println(a / b);
            System.out.println("나누기 끝");

            int c[] = new int[3];
            System.out.println(c[4]);
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("0으로 나눌수 없습니다...");
        }catch (InputMismatchException ie){
            System.out.println("문자 넣으면 안되요...");
        }
        catch (Exception p){
//            p.printStackTrace();
            System.out.println("이것은 모든 예외 상황");
        }

        System.out.println("정상 종료 되었습니다.");
    }
}
