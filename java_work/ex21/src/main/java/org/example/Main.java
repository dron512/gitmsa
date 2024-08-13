package org.example;

public class Main {
    public static void main(String[] args) {
        AAA AAA1 = new AAA("AA");
        AAA AAA2 = new AAA("AA");
        AAA AAA3 = new AAA("AAA");

        AAA1.printThis(AAA2);

        System.out.println(AAA1);
        System.out.println(AAA2);
        System.out.println(AAA3);

        System.out.println(AAA1.equals(AAA2));
        System.out.println(AAA2.equals(AAA1));
        System.out.println(AAA3.equals(AAA1));

        System.out.println(AAA1 == AAA2);
//        A a = new A();
//        a = null;
    }
}