package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        String z = reader.readLine();
        ArrayList<Integer> numbs = new ArrayList<>();
        InputStream inputStream = new FileInputStream(y);
        OutputStream outputStream = new FileOutputStream(z);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            numbs.add(a);
        }

        Collections.reverse(numbs);
        for (Integer a : numbs) {
            outputStream.write(a);
        }
        inputStream.close();
        outputStream.close();
    }
}