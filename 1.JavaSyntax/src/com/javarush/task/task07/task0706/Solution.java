package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a[] = new int[15];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        int m = 0, n = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0 || i == 0)
                m = m + a[i];
            else
                n = n + a[i];
        }
        if (m > n)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}