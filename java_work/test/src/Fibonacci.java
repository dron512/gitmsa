public class Fibonacci {

    static int[] memo = new int[1000];
    public static void main(String[] args) {

        // 1 1 2 3 5 8 ...
        int n = 4;
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if(memo[n] > 0) return memo[n];
        if(n == 0 || n == 1) {
            return n;
        }

        return memo[n] = fibo(n - 2) + fibo(n - 1);
    }
}
