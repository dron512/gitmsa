public class Ex10 {
    /*
    1. 배열 [10,20,30,40,50] 알맞은 코드를 넣어 총합과 평균을 구하세요

    2. 숫자로 이루어진 문자열 이 있을 때 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라
        만일 문자열이 "12345" 면 ‘1+2+3+4+5’ 결과인 15를 출력하여야한다.
        (1) 에 알맞은 코드를 넣으시오 .
        [Hint] String클래스의  charAt(int i) 을 사용

    3. 프로그램 사용자로부터 10진수 형태로 정수를 하나 입력받은 다음, 이를 2진수로 변환해서 출력하는 프로그램을 작성해 보자.

    4. 문자열을 입력받아 거꾸로 출력하는 프로그램을 작성해보자
    예)
     입력 abcdef
     출력 fedcba

     입력 안녕하세요
     출력 요세하녕안
     */
}
// 2번 문제 예시
class Exercise4_9 {
    public static void main(String[] args) {
        String str = "12345";
        char[] a = str.toCharArray();
        System.out.println((int)a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        System.out.println(str.charAt(0)-48);
        System.out.println(str.charAt(1)-48);
        System.out.println(str.charAt(2)-48);
//        int sum = 0;
//        for(int i=0; i < str.length(); i++) {
//
//        }
//        System.out.println("sum="+sum);
    }
}