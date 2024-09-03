package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("myfile"));
        bw.write("글자 잘 써진다");
        bw.newLine();
        bw.close();

    }
}