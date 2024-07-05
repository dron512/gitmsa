public class BB {

    public static String doA(){

        int a = 10;
        System.out.println("doA");
        System.out.println("a = "+a);

        return "a의 값은 = "+a;
    }

    public static void main(String[] args) {
        String a = doA();
        System.out.println("main a = "+a);
    }

}
