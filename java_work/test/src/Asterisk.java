public class Asterisk {

    public static void main(String[] args) {

        int n = 3;

        asterisk(n);
    }

    private static void asterisk(int n) {

        if (n == 0) {
            return;
        }

        System.out.println("*");
        asterisk(n - 1);
        asterisk(n - 1);
    }


}
