package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3202\\Ben.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is != null) {
            StringWriter writer = new StringWriter();
            int a;
            while ((a = is.read()) != -1) {
                writer.write(a);
            }
            return writer;
        }
        return new StringWriter();
    }
}