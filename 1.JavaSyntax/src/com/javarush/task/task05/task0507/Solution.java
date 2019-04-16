package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<>();
        for (; true;) {
            int s = Integer.parseInt(reader.readLine());
            if (s == -1)
                break;
            a.add(s);
        }
        double k = 0;
        for (int i = 0; i < a.size(); i++) {
            k = k + a.get(i);
        }
        System.out.println(k / a.size());
    }
}