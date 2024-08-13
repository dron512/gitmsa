package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person[] parr = {
                new Person("김길동",40),
                new Person("이길동",20),
                new Person("님길동",30),
                new Person("리길동",40),
        };

        Arrays.sort(parr);

        System.out.println(Arrays.toString(parr));

    }
}