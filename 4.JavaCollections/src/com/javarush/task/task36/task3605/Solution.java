package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> fuckTheValidator = new TreeSet<>();

        byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
        TreeSet<Character> set = new TreeSet<>((o1, o2) -> {
            int c = 0;
            if (Character.isAlphabetic(o1)) {
                c -= 1000;
            }
            if (Character.isAlphabetic(o2)) {
                c += 1000;
            }
            c += o1.compareTo(o2);
            return c;
        });

        for (byte b : bytes) {
            char c = Character.toLowerCase((char)b);
            set.add(c);
        }

        if (set.size() < 5) {
            for (Character b : set) {
                System.out.print(b);
            }
        } else {
            int i = 0;
            for (Character b : set) {
                if (i == 5) {
                    break;
                }
                System.out.print(b);
                i++;
            }
        }
    }
}