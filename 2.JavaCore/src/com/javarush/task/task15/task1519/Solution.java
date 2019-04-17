package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution w = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (; true;) {
            String s = reader.readLine();
            if (s.equals("exit"))
                break;
            list.add(s);
        }
        for (String s : list) {
            if (!w.sobaka(s)) {
                print(s);
            }
            else if (s.contains(".")) {
                double d = Double.parseDouble(s);
                print(d);
            }
            else if (!s.contains(".")) {
                int a = Integer.parseInt(s);
                if (a > 0 && a < 128)
                    print((short) a);
                else print(a);
            }

        }
    }

    public boolean sobaka(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}