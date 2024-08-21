package org.example;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex04 {

    public static void main(String[] args) {
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        };

//        TreeSet<String> treeSet = new TreeSet<>(comparator);

        // 람다 ...
        TreeSet<String> treeSet = new TreeSet<>(     (aa, bb) -> bb.length() - aa.length()      );

        treeSet.add("CCC");
        treeSet.add("A");
        treeSet.add("DDDD");
        treeSet.add("BB");

        System.out.println(treeSet);
    }
}
