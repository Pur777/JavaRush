package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            String text = args[2];
            int lenght = text.length();
            long position = Long.parseLong(args[1]);

            byte[] x = new byte[lenght];
            raf.seek(position);
            raf.read(x, 0, lenght);

            raf.seek(raf.length());
            if (new String(x).equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}