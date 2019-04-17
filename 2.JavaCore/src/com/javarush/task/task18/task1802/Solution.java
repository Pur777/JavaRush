package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);
        int min = Integer.MAX_VALUE;
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            if (min > a)
                min = a;
        }
        System.out.println(min);
        reader.close();
        inputStream.close();
    }
}