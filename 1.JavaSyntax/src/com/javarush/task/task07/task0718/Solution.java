package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s);
            a.add(s.length());
        }
        int k;
        boolean m;
        for (int i = 0; i < (a.size() - 1); i++) {
            m = a.get(i) < a.get(i + 1);
            if (!m) {
                k = (i + 1);
                System.out.println(k);
                break;
            }
        }
    }
}