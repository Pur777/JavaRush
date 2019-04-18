package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        BigInteger a = null;
        int b = 36;
        try {
            String s = args[0];
            for (int i = 36; i >= 2; i--) {
                a = new BigInteger(s, i);
                b = i;
            }
        } catch (Exception ignored) {
        } finally {
            if (a != null) {
                System.out.println(b);
            } else {
                System.out.println("incorrect");
            }
        }
    }
}