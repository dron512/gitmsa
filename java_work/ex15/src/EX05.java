public class EX05 {

    public static void main(String[] args) {

        String str0 = "new String";
        String str5 = new String("new String");
        String str6 = str5;

        String str1 = "new String";
        String str2 = "new String";

        System.out.println(str1==str2);

        String str3 = new String("new String");
        String str4 = new String("new String");

        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));

    }
}

