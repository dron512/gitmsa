package org.example;

public class BoxFactory {
    public static <T> void peekBox(Box<T> box){
        System.out.println(box);
    }
    public static void peekBox2(Box<? extends Number> box){
        System.out.println(box);
    }
    public static void peekBox3(Box<Object> box){
        System.out.println(box);
    }

    // 상한제한
    public static void peekBox4(Box<? extends AA> box){
        System.out.println(box);
    }

    // 하한제한
    public static void peekBox5(Box<? super BB> box){
        System.out.println(box);
    }

    // 상한제한
    public static void peekBox6(Box<? extends AA> box){
        AA getbox = box.getT();
        System.out.println(getbox);
//        box.setT(new AA());
    }

//    public static void peekBox6(Box<? extends BB> box){
//        AA getbox = box.getT();
//        System.out.println(getbox);
//        box.setT(new AA());
//    }

    // 하한제한
    public static void peekBox7(Box<? super AA> box){
//        AA getbox = box.getT();
//        System.out.println(getbox);
        box.setT(new AA());
    }

    public static <T> T getMyBox1(Box<? extends T> box){
        return box.getT();
    }

//    public static <T> T getMyBox2(Box<? super T> box){
//        return box.getT();
//    }

}
