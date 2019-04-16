package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        for (int j = 0; j < 1; j++) {
            int a = Integer.parseInt(reader.readLine());
            if (a < 0)
                break;
            for (int i = 0; i < a; i++) {
                int b = Integer.parseInt(reader.readLine());
                if (b > maximum)
                    maximum = b;
            }
            System.out.println(maximum);
        }
    }
}