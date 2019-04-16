package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> pes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            pes.add(reader.readLine());
        }
        for (int i = 0; i < 13; i++) {
            String s = pes.get(4);
            pes.remove(4);
            pes.add(0, s);
        }
        for (int i = 0; i < pes.size(); i++) {
            System.out.println(pes.get(i));
        }
    }
}