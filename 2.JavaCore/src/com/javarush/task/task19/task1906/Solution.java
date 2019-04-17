package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        String z = reader.readLine();
        reader.close();

        FileReader reader1 = new FileReader(y);
        FileWriter writer = new FileWriter(z);
        int count = 1;
        while (reader1.ready()) {
            int data = reader1.read();
            if (count % 2 == 0) {
                writer.write(data);
            }
            count++;
        }
        reader1.close();
        writer.close();
    }
}