package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[20];
        int[] b = new int[10];
        int[] c;
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        c = Arrays.copyOfRange(a, 10, 20 );

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}