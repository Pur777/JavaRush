package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> pes = new ArrayList<>();
        pes.add("мама");
        pes.add("мыла");
        pes.add("раму");
        pes.add(1, "именно");
        pes.add(3, "именно");
        pes.add(5, "именно");
        for (int i = 0; i < pes.size(); i++) {
            System.out.println(pes.get(i));
        }
    }
}