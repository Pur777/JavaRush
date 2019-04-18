package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile(args[0], "w");
            long seek = Long.parseLong(args[1]);
            if (seek > accessFile.length()) {
                accessFile.seek(accessFile.length());
            } else {
                accessFile.seek(seek);
            }
            accessFile.write(args[2].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}