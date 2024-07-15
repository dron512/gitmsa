import java.util.Scanner;

class Exam {
    Scanner scan = new Scanner(System.in);

    public int inputNumber() {
        System.out.println("숫자 입력");
        int inputNumber = scan.nextInt();
        System.out.println("inputnumber().inputnumber = " + inputNumber);
        return inputNumber;
    }
}
