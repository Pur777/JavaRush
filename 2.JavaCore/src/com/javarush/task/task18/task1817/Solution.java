package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        int count = inputStream.available();
        int count2 = 0;
        while (inputStream.available() > 0) {
            char c = (char) inputStream.read();
            if (c == ' ')
                count2++;
        }

        System.out.println(String.format("%.2f", (count2 / (double)count * 100)));
        inputStream.close();
    }
}