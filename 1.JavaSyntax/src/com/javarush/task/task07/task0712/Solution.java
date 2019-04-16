package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> pes = new ArrayList<>();
        int[] a = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            pes.add(s);
            a[i] = s.length();
        }
        int max = a[0];
        for (int i = 0; i < pes.size(); i++) {
            if (a[i] > max)
                max = a[i];
        }
        int min = a[0];
        for (int i = 0; i < pes.size(); i++) {
            if (a[i] < min)
                min = a[i];
        }
        int k = 0, b = 0;
        for (int i = 0; i < pes.size(); i++) {
            if (a[i] == max) {
                k = i;
                break;
            }
        }
        for (int i = 0; i < pes.size(); i++) {
            if (a[i] == min) {
                b = i;
                break;
            }
        }

        if (k < b)
            System.out.println(pes.get(k));
        else
            System.out.println(pes.get(b));
    }
}