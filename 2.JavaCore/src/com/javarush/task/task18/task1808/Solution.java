package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        String y = reader.readLine();
        String z = reader.readLine();
        ArrayList<Integer> numbIn = new ArrayList<>();
        ArrayList<Integer> numbOut1 = new ArrayList<>();
        ArrayList<Integer> numbOut2 = new ArrayList<>();

        InputStream inputStream = new FileInputStream(x);
        OutputStream outputStream = new FileOutputStream(y);
        OutputStream outputStream2 = new FileOutputStream(z);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            numbIn.add(a);
        }

        if (numbIn.size() % 2 == 0) {
            for (int i = 0; i < numbIn.size() / 2; i++) {
                numbOut1.add(numbIn.get(i));
            }
            for (int i = numbIn.size() / 2; i < numbIn.size(); i++) {
                numbOut2.add(numbIn.get(i));
            }
        } else {
            for (int i = 0; i < (numbIn.size() / 2) + 1; i++) {
                numbOut1.add(numbIn.get(i));
            }
            for (int i = (numbIn.size() / 2) + 1; i < numbIn.size(); i++) {
                numbOut2.add(numbIn.get(i));
            }
        }
        for (Integer a : numbOut1) {
            outputStream.write(a);
        }

        for (Integer a: numbOut2) {
            outputStream2.write(a);
        }
        reader.close();
        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}