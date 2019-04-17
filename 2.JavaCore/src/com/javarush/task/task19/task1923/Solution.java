package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> date = solution.getDate(args[0]);
        for (int i = 0; i < date.size(); i++) {
            if (!solution.numb(date.get(i))) {
                date.remove(i);
                i--;
            }
        }
        solution.wriite(date, args[1]);
    }

    public ArrayList<String> getDate(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] ss = s.split(" +");
                Collections.addAll(list, ss);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean numb(String slovo) {
        boolean is = false;
        char[] word = slovo.toCharArray();
        for (char c : word) {
            if (Character.isDigit(c)) {
                is = true;
                break;
            }
        }
        return is;
    }
    public void wriite(ArrayList<String> list, String fileWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite))) {
            for (String s : list) {
                writer.write(s + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}