package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        String z = reader.readLine();
        InputStream inputStream1 = new FileInputStream(y);
        InputStream inputStream2 = new FileInputStream(z);

        ArrayList<Integer> numb = new ArrayList<>();
        while (inputStream2.available() > 0) {
            int a = inputStream2.read();
            numb.add(a);
        }
        while (inputStream1.available() > 0) {
            int a = inputStream1.read();
            numb.add(a);
        }
        OutputStream outputStream = new FileOutputStream(y);
        for (int i = 0; i < numb.size(); i++) {
            outputStream.write(numb.get(i));
        }
        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}