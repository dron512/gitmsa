package org.example;

import java.io.*;

class MyObject implements Serializable {
    private String test = "aaa";
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
}

public class Ex01 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream
                oos = new ObjectOutputStream(new FileOutputStream("d:/a/obj"));
        oos.writeObject(new MyObject());
        oos.close();

        // 예외 발생하게되면 프로그램 강제종료..

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("d:\\a\\obj"));
        Object aaa = ois.readObject();
        MyObject mo = (MyObject) aaa;
        System.out.println(mo.getTest());
    }
}
