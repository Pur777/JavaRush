package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        String y = reader.readLine();
        String z = reader.readLine();
        InputStream inputStream = new FileInputStream(y);
        InputStream inputStream2 = new FileInputStream(z);
        OutputStream outputStream = new FileOutputStream(x);
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            outputStream.write(a);
        }
        while (inputStream2.available() > 0) {
            int a = inputStream2.read();
            outputStream.write(a);
        }
        inputStream.close();
        inputStream2.close();
        outputStream.close();
    }
}