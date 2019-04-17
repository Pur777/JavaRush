package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);
        ArrayList<Integer> numbs = new ArrayList<>();
        ArrayList<Integer> maxNumbs = new ArrayList<>();
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            numbs.add(a);
        }
        Collections.sort(numbs);
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbs.size() - 1; i++) {

            if (numbs.get(i) == numbs.get(i + 1)) {
                count++;
                if (max < count)
                    max = count;
            }
            else count = 1;
        }
        for (int i = 0; i < numbs.size() - 1; i++) {
            if (numbs.get(i) == numbs.get(i + 1)) {
                count++;
                if (count == max) {
                        maxNumbs.add(numbs.get(i));
                }
            } else {
                count = 1;
            }
        }
        for (Integer i : maxNumbs) {
            System.out.print(i + " ");
        }
        reader.close();
        inputStream.close();
    }
}