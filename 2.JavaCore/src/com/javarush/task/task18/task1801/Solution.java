package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numb = new ArrayList<>();
        String s = reader.readLine();
        InputStream inStream = new FileInputStream(s);
        int max = Integer.MIN_VALUE;
        while (inStream.available() > 0) {
            int a = inStream.read();
            numb.add(a);
            if (max < a)
                max = a;
        }
        System.out.println(max);
        reader.close();
        inStream.close();
    }
}