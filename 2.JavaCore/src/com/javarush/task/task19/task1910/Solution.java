package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String y;
        String z;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            y = reader.readLine();
            z = reader.readLine();
        }

        String italon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        italon = italon + italon.toLowerCase() + "0123456789 ";
        char[] ita = italon.toCharArray();

        ArrayList<Character> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(y))) {
            while (reader.ready()) {
                char a = (char)reader.read();
                for (char b : ita) {
                    if (a == b) {
                        data.add(a);
                    }
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(z))) {
            for (Character a : data) {
                writer.write(a);
            }
        }
    }
}