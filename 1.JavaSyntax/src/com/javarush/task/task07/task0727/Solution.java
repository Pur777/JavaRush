package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
        ArrayList<Integer> listUpperCase = new ArrayList<>();
        int a;
        for (int i = 0; i < list.size(); i++) {
            a = list.get(i).length();
            listUpperCase.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            String s, z;
            if (listUpperCase.get(i) % 2 == 0) {
                s = list.get(i) + " " + list.get(i);
                list.set(i, s);
            }
            else if (listUpperCase.get(i) % 2 != 0) {
                z = list.get(i) + " " + list.get(i) + " " + list.get(i);
                list.set(i, z);
            }
        }

        for (int i = 0; i < listUpperCase.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}