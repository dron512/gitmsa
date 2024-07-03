package ex05;

public class Ex04 {

	public static void main(String[] args) {

		int F = 100;
		float C = (float) ((F - 32) / 1.8);
		
		System.out.println("F = " + F);
		System.out.println(C);
		
		int k = (int) (C * 100);
		
		System.out.println(k / 100.0);
//		System.out.println("C = " + Math.round(C));

	}

}
