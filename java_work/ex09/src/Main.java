import java.util.Scanner;
import aa.bb.Fact;

/*
    2*2*2
 */
public class Main {
    public static void main(String[] args) {
        // 입력받는 변수 선언
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 입력");
        int result = scanner.nextInt();

        Fact fact1 = new Fact();
        int retValue = fact1.aa(result);

        result = fact1.aa(5);

        System.out.println("result = "+result);
        System.out.println("retValue = "+retValue);


//        Fact fact2 = new Fact();

    }
}