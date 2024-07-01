package ex03;

public class Ex05 {
	
	public static void doA() {
		int c = 10;
	}
	public static void main(String[] args) {
		// ctrl + 1 빠른 에러처리
		double a = 10.345;
		int b = (int) a;
		System.out.println(a);
		System.out.println(b);
		
		double c = 11.39;
		int d = (int) a;
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(c);
		System.out.println(d);
		doA();
	}
	
}
