package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Integer> numb = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        InputStream inputStream = new FileInputStream(s);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            set.add(a);
        }
        numb.addAll(set);
        Collections.sort(numb);
        for (Integer i : numb) {
            System.out.print(i + " ");
        }
        reader.close();
        inputStream.close();
    }
}