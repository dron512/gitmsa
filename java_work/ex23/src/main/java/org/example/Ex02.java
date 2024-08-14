package org.example;

public class Ex02 {

    public static void main(String[] args) {
        BoxFactory.peekBox6(new Box<>(new AA()));
        BoxFactory.peekBox7(new Box<>(new AA()));

        BB bb = BoxFactory.<BB>getMyBox1(new Box<>(new BB()));
        AA aa = BoxFactory.<AA>getMyBox1(new Box<>(new AA()));

        BB bb1 = BoxFactory.getMyBox1(new Box<>(new BB()));
        AA aa1 = BoxFactory.getMyBox1(new Box<>(new AA()));

        Object obj = new Object();
        String str = "asdfsadf";

        System.out.println(obj.getClass());
        System.out.println(str.getClass());

        obj = str;
        System.out.println(obj.getClass());
        int a = 10;
        obj = a;
        System.out.println(obj.getClass());
    }

}