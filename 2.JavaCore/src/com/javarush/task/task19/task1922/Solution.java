package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String z = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            z = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> data = solution.getDate(z);

        for (String s : data) {
            if (solution.countWords(s) == 2) {
                System.out.println(s);
            }
        }
    }
    public ArrayList<String> getDate(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int countWords(String stroka) {
        String[] slova = stroka.split(" +");
        int a = 0;
        for (String s : slova) {
            for (String z : words) {
                if (s.equals(z)) {
                    a++;
                }
            }
        }
        return a;
    }
}