package org.example;

// ctrl + space enter
// ctrl + space enter
// alt + enter enter
public class LPrint implements Printable{
    @Override
    public void print(String doc) {
        System.out.println("LG프린터");
        System.out.println(doc);
    }
    @Override
    public void doA() {
    }
}
