package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();

        String[] xxx = s.split("\\s+");
        for (int i = 0; i < xxx.length; i++) {
            xxx[i] = xxx[i].substring(0,1).toUpperCase() + xxx[i].substring(1) + " ";
        }
        for (int i = 0; i < xxx.length; i++) {
            System.out.print(xxx[i]);
        }
    }
}