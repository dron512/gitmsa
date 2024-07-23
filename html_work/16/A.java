import java.lang.reflect.Array;
import java.util.Arrays;

class A{
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int b[] = new int[3];
        int c = 2;

        System.arraycopy(a, c, b, 0, 3);

        System.out.println(Arrays.toString(b));
    }
}