package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String q = reader.readLine();
        String s = reader.readLine();
        if (q.equals(s))
            System.out.println("Имена идентичны");
        else if (q.length() == s.length())
            System.out.println("Длины имен равны");
    }
}