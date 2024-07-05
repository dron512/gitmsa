package ex06;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		String age_type = sc.next();
		int answer = 0;

		// a == 10 숫자 비교
		// a.equals("10") 문자열 비교
		// 프로그래머스.... 쉬운거... 어려운거...

		if (age_type.equals("KOREA")) {
			answer = 2030 - year + 1;
		} else if (age_type.equals("Year")) {
			answer = 2030 - year;
		}

		System.out.println("age_type = " + age_type);
		System.out.println("answer = " + answer);
		System.out.println("year = " + year);
	}
}
