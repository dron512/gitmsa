package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // List 1,2,3,4,5,6,7,8,9 생성 해서 스트림으로 만들어 가지고
        // 1. 그냥 출력
        // 2. 홀수,짝수 sum총합 출력하기
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream()
                .forEach(s -> System.out.println(s));

        int result = list.stream()
                .mapToInt(value -> value)
                .sum();
        System.out.println("result = " + result);

        result = list.stream()
                .reduce(0, (a, b) -> {
                    return a + b;
                });
        System.out.println("result = " + result);

        result = list.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, (a, b) -> {
                    return a + b;
                });
        System.out.println("result = " + result);

        result = list.stream()
                .filter(integer -> integer % 2 == 1)
                .reduce(0, (a, b) -> {
                    return a + b;
                });
        System.out.println("result = " + result);
    }
}