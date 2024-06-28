package aa;

public class Ex03 {
	public static void main(String[] args) {
		// byte - short - int cpu 32비트 4byte
		// int 4byte 32bit
		// short 2byte 16bit
		// 0000 0000 0000 0000 16개
		// 0000 0000 0000 0000 0000 0000 0000 0000 32개
		// 10진수 10000
		// 10진수 000 <- 10000? 
		short a = 11;
		short b = 22;
		
		short result = (short) (a + b);
		
		System.out.println(a+b);
		System.out.println(result);
	}
}
