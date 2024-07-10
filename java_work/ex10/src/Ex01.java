class A{}

public class Ex01 {

    public static void main(String[] args) {
        A a = new A();
        A b = a;

        System.out.println(a==b);

        // int double float
        // String
        String str1 = new String("happy");
        String str2 = "happy";
        String str3 = "happy";

        System.out.println(str1 + " " + str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2 == str3);
    }

}
