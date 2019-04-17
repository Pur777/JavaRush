package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> data = solution.getData(args[0]);
        solution.nameRich(data);
        for (String s : data) {
            System.out.println(s);
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
    public void nameRich(ArrayList<String> list) {
        Collections.sort(list);
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> cash = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] ss = list.get(i).split(" +");
            name.add(ss[0]);
            cash.add(Double.parseDouble(ss[1]));
        }

        for (int i = 0; i < name.size() - 1; i++) {
            if (name.get(i).equals(name.get(i + 1))) {
                cash.set(i, (cash.get(i) + cash.get(i + 1)));
                cash.remove(i + 1);
                name.remove(i + 1);
                i--;
            }
        }

        for (int i = 0; i < cash.size(); i++) {
            for (int j = 0; j < cash.size(); j++) {
                if (cash.get(i) < cash.get(j) && i < j) {
                    Collections.swap(cash, i, j);
                    Collections.swap(name, i, j);
                }
            }
        }

        list.clear();
        list.add(name.get(0));
        for (int i = 1; i < name.size(); i++) {
            if (cash.get(0).equals(cash.get(i))) {
                list.add(name.get(i));
            }
        }
        Collections.sort(list);
    }
}