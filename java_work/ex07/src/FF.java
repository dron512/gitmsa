public class FF {

    public static void main(String[] args) {

        System.out.println();

        // 0 < result < 1
        // 0.0000001 <= result <=0.9999999
        // 0.0000100 <=result <=99.9999999
        // 3.0000100<=result <=102.9999999

        // int 형변환
        // 3<=result<=102

        for (int i = 0; i < 10000; i++) {
            double result = Math.random()*100+3;

            System.out.println((int)result);
        }

    }

}
