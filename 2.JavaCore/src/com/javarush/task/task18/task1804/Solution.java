package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Integer> numb = new ArrayList<>();
        ArrayList<Integer> countNumbs = new ArrayList<>();
        ArrayList<Integer> mixNumb = new ArrayList<>();

        reader.close();

        InputStream inputStream = new FileInputStream(s);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            numb.add(a);
        }
        inputStream.close();
        Collections.sort(numb);
        mixNumb.addAll(numb);
        for (Integer i : numb) {
            countNumbs.add(0);
        }
        for (int i = 0; i < numb.size(); i++) {
            for (int j = 0; j < mixNumb.size(); j++) {
                if (numb.get(i) == mixNumb.get(j)) {
                    countNumbs.set(i, countNumbs.get(i) + 1);
                }
            }
        }
        mixNumb.clear();
        for (int i = 0; i < countNumbs.size(); i++) {
            if (countNumbs.get(i) == Collections.min(countNumbs)) {
                mixNumb.add(numb.get(i));
            }
        }
        for (Integer i : mixNumb) {
            System.out.print(i + " ");
        }

    }
}