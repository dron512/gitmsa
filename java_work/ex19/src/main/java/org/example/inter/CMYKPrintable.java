package org.example.inter;

// 클래스 간 상속.. extends
// 인터페이스간 상속 extends
public interface CMYKPrintable extends Printable{
    void printCMYK(String doc);
}
