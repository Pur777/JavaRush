package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> pes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pes.add(reader.readLine());
        }
        pes.remove(2);
        for (int i = (pes.size() - 1); i >= 0; i--) {
            System.out.println(pes.get(i));
        }
    }
}
