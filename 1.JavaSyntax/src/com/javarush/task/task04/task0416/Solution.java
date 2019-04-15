package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        double x = t % 5.0;

        if (x < 3)
            System.out.println("зеленый");
        else if (x >= 3 && x < 4)
            System.out.println("желтый");
        else
            System.out.println("красный");
    }
}