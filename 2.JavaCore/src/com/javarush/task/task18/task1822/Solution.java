package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> productName = new ArrayList<>();
        ArrayList<String> split = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        InputStream inputStream = new FileInputStream(s);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        String z;
        while ((z = reader.readLine()) != null) {
            productName.add(z);
        }

        for (String y : productName) {
            for (String x : y.split(" ")) {
                split.add(x);
            }
            if (split.get(0).equals(String.valueOf(args[0]))){
                System.out.println(y);
            }
            split.clear();
        }
        inputStream.close();
        reader.close();
    }
}