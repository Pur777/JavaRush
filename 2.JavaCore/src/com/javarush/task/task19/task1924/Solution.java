package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
?????? ?????
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String z = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            z = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> date = solution.getData(z);
        for (String s : date) {
            System.out.println(solution.setData(s));
        }
    }

    public ArrayList<String> getData(String fileName) {
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
    public String setData(String stroka) {
        String[] ss = stroka.split(" +");
        for (int i = 0; i < ss.length; i++) {
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                if (ss[i].equals(String.valueOf(pair.getKey()))) {
                    ss[i] = pair.getValue();
                }
            }
        }
        String set = "";
        for (String s : ss) {
            set += s + " ";
        }
        return set.trim();
    }
}