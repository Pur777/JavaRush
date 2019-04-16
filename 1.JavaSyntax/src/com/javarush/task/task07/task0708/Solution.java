package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int[] a = new int[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            strings.add(s);
            a[i] = s.length();
        }

        int max = a[0];
        for (int i = 0; i < strings.size(); i++) {
            if (a[i] > max)
                max = a[i];
        }

        for (String w : strings) {
            if (w.length() == max)
                System.out.println(w);
        }
    }
}