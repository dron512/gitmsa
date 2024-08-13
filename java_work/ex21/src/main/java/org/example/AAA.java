package org.example;

public class AAA extends Object {
    private String name;

    public AAA(String name) {
        this.name = name;
    }

    public void printThis(Object obj) {
        System.out.println("this = " + this);
        System.out.println("(A)obj = " + (AAA) obj);
        System.out.println("this.name = " + this.name);
        System.out.println("((A)obj).name = " + ((AAA) obj).name);
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((AAA) o).name);
    }

}
