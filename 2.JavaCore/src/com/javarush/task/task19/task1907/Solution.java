package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String z = reader.readLine();
        reader.close();

        String alphabet = "!,.?;:'|-()*\r\n";
        char[] alpha = alphabet.toCharArray();

        FileReader fileReader = new FileReader(z);
        ArrayList<Character> c = new ArrayList<>();
        while (fileReader.ready()) {
            char x = (char)fileReader.read();
            c.add(x);
        }

        for (int i = 0; i < c.size(); i++) {
            for (Character b : alpha) {
                if (c.get(i) == b) {
                    c.set(i, ' ');
                }
            }
        }
        String str = "";
        for (Character a : c) {
            str += a;
        }
        String[] zzz = str.split(" +");
        int count = 0;
        for (String a : zzz) {
            if (a.equals("world")) {
                count++;
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}