//1. 두 개의 주사의 던졌을때,
// 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
// A주사위 B주사위

// 1일때 1~5  만약에
// 2일때 1~5
// 3일때 1~5
// 4일때 1~5
// 5일때 1~5

// 1       5
// 2       4
// 3       3
// 4       2
// 5       1

public class Ex01 {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if((i+j)==6){
                    System.out.print("i= "+i+" ");
                    System.out.println("j= "+j);
                }
            }
        }


    }

}

