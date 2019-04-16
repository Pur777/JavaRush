package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> pes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            String so = reader.readLine();
            pes.add(so);
            a[i] = so.length();
        }
        int min = a[0];
        for (int i = 0; i < pes.size(); i++) {
            if (a[i] < min)
                min = a[i];
        }
        for (int i = 0; i < pes.size(); i++) {
            String w = pes.get(i);
            if (w.length() == min)
                System.out.println(w);
        }
    }
}