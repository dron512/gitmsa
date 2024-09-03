package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class Ex03 {

    public static void main(String[] args) throws IOException {


        // 파일업로드...
        // A 파일업로드..
        // d:upload

        // a폴더 밑에 b 폴더 밑에 myfile 생성
        Files.createFile(Paths.get("d:/a/b/myfile"));

        Files.createFile(Paths.get("d:/a/b/c/myfile"));

        Files.createDirectory(Paths.get("d:/a/bbb"));

    }
}
