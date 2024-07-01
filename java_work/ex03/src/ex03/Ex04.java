package ex03;

public class Ex04 {
	
	public static void main(String[] args) {
		// 강제 형변환
		// int 4byte short 2byte
		// 8bit -> 1byte
		// 4byte -> 2byte
		int num1 = 413514651;
		
		// short 32000 -> 데이터 소실...
		short num2 = (short) num1;
		
		// 자동 형변환
		// 반대 -> 자동형변환
		short num3 = 20;
		int num4 = num3;
		
		short kk = 20;
		double aa = 10.03;
		
		kk = (short) aa;
	}
}




