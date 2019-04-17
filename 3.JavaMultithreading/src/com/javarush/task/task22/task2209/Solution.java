package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String z;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            z = reader.readLine();
        }
        Solution solution = new Solution();
        String [] x = solution.getData(z);

        StringBuilder result = getLine(x);
        System.out.println(result.toString());
    }
    public String[] getData(String fileName) throws IOException {
        ArrayList<String> list  = new ArrayList<>();
        String[] word;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] ss = s.split(" +");
                for (String y : ss) {
                    list.add(y);
                }
            }
        }
        word = new String[list.size()];
        for (int i = 0; i < word.length; i++) {
            word[i] = list.get(i);
        }
        return word;
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0){
            return new StringBuilder();
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (String s : words) {
                list.add(s);
            }
            StringBuilder line = new StringBuilder(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                for (int j = 1; j < list.size(); j++) {
                    if (list.get(j) != null && line.toString().substring(line.length() - 1).equalsIgnoreCase(list.get(j).substring(0, 1)) && i != j) {
                        line.append(" " + list.get(j));
                        list.set(j, null);
                    }
                    else if (list.get(j) != null && line.toString().substring(0, 1).equalsIgnoreCase(list.get(j).substring(list.get(j).length() - 1)) && i != j) {
                        line.insert(0, list.get(j) + " ");
                        list.set(j, null);
                    }
                }
            }

            return line;
        }
    }
}