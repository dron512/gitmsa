import java.util.Arrays;

public class Ex05 {

    public static void main(String[] args) {
        int ar[] = new int[5];

//        ar = {3,3,3,3,3};

        Arrays.fill(ar,3);

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        Arrays.fill(ar,0,2,10);

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

    }
}
