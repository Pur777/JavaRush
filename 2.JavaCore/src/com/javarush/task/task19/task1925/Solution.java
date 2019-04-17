package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> data = solution.getData(args[0]);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).length() <= 6) {
                data.remove(i);
                i--;
            }
        }
        solution.writer(data, args[1]);

    }
    public ArrayList<String> getData(String fileName) {
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
    public void writer(ArrayList<String> list, String fileName) {
        String str = "";
        for (String s : list) {
            str += s + ",";
        }
        str = str.substring(0, str.length() - 1);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}