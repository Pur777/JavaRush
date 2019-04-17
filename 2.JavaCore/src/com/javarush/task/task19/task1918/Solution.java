package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();

        String z;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            z = reader.readLine();
        }
        String text = solution.getData(z);
        String open = "<" + args[0];
        String close = "</" + args[0] + ">";
        ArrayList<Integer> opens = new ArrayList<>();
        ArrayList<Integer> closes = new ArrayList<>();
        ArrayList<Boolean> flag = new ArrayList<>();

        for (int i = 0; i < text.length() - close.length() + 1; i++) {
            if (text.substring(i, i + open.length()).equals(open)) {
                opens.add(i);
                flag.add(false);
            }
            if (text.substring(i, i + close.length()).equals(close)) {
                closes.add(i + close.length());
            }
        }

        ArrayList<String> list = new ArrayList<>();

        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < text.length() + 1; i++) {
            if (i == closes.get(b)) {
                for (int j = c; j >= 0; j--) {
                    if (flag.get(j) == true) {
                        list.set(j, list.get(j) + i);
                        flag.set(j, false);
                        b++;
                        break;
                    }
                }
            }
            if (i == opens.get(a)) {
                list.add(opens.get(a) + " ");
                flag.set(a, true);
                if (a != opens.size() - 1) {
                    a++;
                    c++;
                }

            }
        }

        for (String s : list) {
            String[] ss = s.split(" +");
            System.out.println(text.substring(Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
        }

    }
    public String getData(String fileName) {
        String y = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                y += s;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return y;
    }
}