import aa.CalSecond;

import java.util.Scanner;

/*

2. 프로그램 사용자로부터 초(second)를 입력받은 후에,
 이를 [시, 분, 초]의 형태로 출력하는 프로그램을 작성해 보자.

 */
public class Main {


    public static void main(String[] args) {

        System.out.println("초입력: ");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        int hour = result / 3600;
        int min = (result%3600)/60;
        int sec = (result%3600)%60;

        System.out.println( hour+"시간 "+min+"분 "+sec+"초");

        /*
        CalSecond calSecond = new CalSecond();

        int retValue = calSecond.inputNumber();
        System.out.println(retValue);

        String resultValue = calSecond.calculate(retValue);
        System.out.println(resultValue);
         */


//        System.out.println(calSecond.inputNumber());

//        CalSecond calSecond2 = calSecond;
//
//        System.out.println(calSecond);
//        System.out.println(calSecond2);


    }



}