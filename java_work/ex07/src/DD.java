import java.util.Scanner;

public class DD {
    // 1+2+3+4+ ~ 10 까지 더하는 메서드 55
    public static void doA(int end) {
        int sum = 0;
        for (int i = 1; i < end + 1; i++) {
            sum = sum + i;
        }
        System.out.println("1부터 " + end + "까지 더한 수 " + sum);
    }

    // 1*2*3*4*5*6*10 까지 곱하는 메서드
    public static void doB(int end) {
        int sum = 1;
        for (int i = 1; i < end + 1; i++) {
            sum = sum * i;
        }
        System.out.println("1부터 " + end + "까지 곱한 수 " + sum);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("몇까지 더할까요?");
        int test = scan.nextInt();

        doA(test);
        doB(test);

    }

}
