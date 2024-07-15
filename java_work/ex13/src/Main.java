/*
    10진수 입력받아 2진수 출력...
 */

public class Main {
    public static void main(String[] args) {
        Exam exam = new Exam();
        int result = exam.inputNumber();
        System.out.println("main.result = "+result);

        // 10 / 2
        int 몫,나머지;

        몫 = result/2;
        나머지 = result%2;

        System.out.println("몫 = "+몫);
        System.out.println("나머지 = "+나머지);
        String 나머지들 = ""+나머지;

        while(true){
            나머지 = 몫%2;
            몫 = 몫/2;
            나머지들 = 나머지 + 나머지들;

            System.out.println("몫 = "+몫);
            System.out.println("나머지 = "+나머지);
            System.out.println("나머지들 = "+나머지들);

            if( 몫 <2){
                if(몫 !=0) {
                    나머지들 = 몫 + 나머지들;
                    System.out.println("나머지들 = " + 나머지들);
                }
                break;
            }
        }
    }
}











