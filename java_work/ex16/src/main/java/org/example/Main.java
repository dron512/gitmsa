package org.example;
/*
1. Student 클래스를 작성하는 연습을 해보도록하자.
    Student클래스에 getTotal() getAverage() 과 를 추가하시오
    75 90 88
    1. :  getTotal 메서드
    기 능 국어 영어 수학 의 점수를 모두 더해서 반환한다 :
        (kor), (eng), (math) .
        반환타입 : int
        매개변수 없음 :
    2. : getAverage 메서드
    기 능 총점 국어점수 영어점수 수학점수 을 과목수로 나눈 평균을 구한다 : ( + + ) .
    소수점 둘째자리에서 반올림할 것.
    반환타입 : float
    매개변수 없음

2. 노래 한 곡을 나타내는 Song 클래스를 작성하라. Song은 다음 필드로 구성된다.
    - 노래의 제목을 나타내는 title
    - 가수를 나타내는 artist
    - 노래가 발표된 연도를 나타내는 year
    - 국적을 나타내는 country
    또한 Song 클래스에 다음 생성자와 메소드를 작성하라.

    - 생성자 2개: 기본 생성자와 매개변수로 모든 필드를 초기화하는 생성자
    - 노래 정보를 출력하는 show() 메소드
    - main() 메소드에서는 1978년, 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을
        song 객체로 생성하고 show()를 이용하여 노래의 정보를 다음과 같이 출력하라.
        1978년 스웨덴국적의 ABBA가 부른 Dancing Queen
 */

import org.example.aa.Student;

public class Main {

    Main(){
        Student student = new Student(
                "홍길동",90,80,60);
        System.out.println(student);

        float result = student.getAverage();
        System.out.println(result);
        System.out.println(student.getTotal());
    }

    public static void main(String[] args) {
        new Main();

    }
}