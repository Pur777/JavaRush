package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        ArrayList<Integer> symbol1 = new ArrayList<>();
        HashSet<Integer> collect = new HashSet<>();
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Integer> symbol2 = new ArrayList<>();
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            symbol1.add(a);
        }

        collect.addAll(symbol1);
        for (Integer a : collect) {
            count.add(0);
            symbol2.add(a);
        }
        Collections.sort(symbol2);

        for (int i = 0; i < symbol2.size(); i++) {
            for (int j = 0; j < symbol1.size(); j++) {
                if (symbol2.get(i) == symbol1.get(j)) {
                    count.set(i, count.get(i) + 1);
                }
            }
        }

        for (int i = 0; i < symbol2.size(); i++) {
            int a = symbol2.get(i);
            System.out.println((char)a + " " + count.get(i));
        }
        inputStream.close();
    }
}