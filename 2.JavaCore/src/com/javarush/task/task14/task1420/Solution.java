package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(reader.readLine());

            b = Integer.parseInt(reader.readLine());

            if (a <= 0 || b <= 0)
                throw new NullPointerException();
        } catch (IOException e) {

        }
        int c;
        if (a >= b)
            c = a;
        else
            c = b;
        for (int i = c; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                c = i;
                break;
            }
        }
        System.out.println(c);
    }
}