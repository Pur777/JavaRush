package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        ArrayList<Integer> fuck = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            fuck.add(array[i]);
        }
        Collections.sort(fuck);
        Collections.reverse(fuck);
        for (int i = 0; i < array.length; i++) {
            array[i] = fuck.get(i);
        }
    }
}