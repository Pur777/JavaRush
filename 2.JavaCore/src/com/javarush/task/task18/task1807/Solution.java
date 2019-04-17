package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numb = new ArrayList<>();
        String s = reader.readLine();
        InputStream inputStream = new FileInputStream(s);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            numb.add(a);
        }
        int count = 0;
        char character = ',';
        int ascii = (int) character;
        for (int i = 0; i < numb.size(); i++) {
            if (numb.get(i) == ascii)
                count++;
        }
        System.out.println(count);
        reader.close();
        inputStream.close();
    }
}