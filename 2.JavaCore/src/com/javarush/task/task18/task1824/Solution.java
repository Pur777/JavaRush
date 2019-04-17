package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<InputStream> list = new ArrayList<>();
        String s = null;
        while (true) {
            try {
                s = reader.readLine();
                list.add(new FileInputStream(s));
            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            } finally {
                for (InputStream i : list) {
                    i.close();
                }

            }
        }
    }
}