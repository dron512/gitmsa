package ex06;

public class Ex02 {

	public static void main(String[] args) {
		for (int i = 2; i < 10; i+=2) {
			for (int j = 1; j < 8; j++) {
				if(j==4)
					continue;
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}
	}
}
