package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int c = Collections.min(array);
        return c;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> xxx = new ArrayList<>();
        int a = Integer.parseInt(reader.readLine());
        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(reader.readLine());
            xxx.add(b);
        }
        return xxx;
    }
}