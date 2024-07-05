package ex06;

public class Ex05 {

	public static double aa() {
		System.out.println("aa");
		return 10;
	}
	public static void main(String[] args) {
		aa();
		int a = (int) aa();
		System.out.println(a);
	}
}
