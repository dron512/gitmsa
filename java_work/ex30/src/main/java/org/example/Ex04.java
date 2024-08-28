package org.example;

import java.util.Optional;

public class Ex04 {

    public static void main(String[] args) {

        // prepareStatement("select * from member");

        Optional<String> os1 = Optional.of("TOY1");
        System.out.println(os1);
        System.out.println(os1.get());

        Optional<String> os2 = Optional.ofNullable("TOY2");
        System.out.println(os2);
        System.out.println(os2.get());

        Optional<String> os3 = Optional.ofNullable("TOY3");
        System.out.println(os3);
        
        os3.ifPresent(System.out::println);
        os3.ifPresentOrElse(System.out::println,() -> System.out.println("없음"));
        
//        os3.ifPresentOrElse();

    }

}
