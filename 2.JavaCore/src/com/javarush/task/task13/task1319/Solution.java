package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        OutputStream outputStream = new FileOutputStream(s);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (; true;) {
            String w = reader.readLine();
            writer.write(w);

            if (w.equals("exit"))
                break;
            writer.write("\r\n");
        }
        writer.close();
    }
}