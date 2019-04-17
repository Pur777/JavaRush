package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {

    public static void listPrint(ArrayList<String> list) {
        for (String z : list) {
           System.out.print(z + " ");
        }
        System.out.println();
    }
    public static ArrayList<String> list(String url) {
        char[] c = url.toCharArray();
        int a = 0;
        for (int i =0; i < c.length; i++) {
            if (c[i] == '?')
                a = i + 1;
        }
        String y = url.substring(a);
        ArrayList<String> list = new ArrayList<>();

        for (String retval : y.split("&")) {
            list.add(retval);
        }
        return list;
    }
    public static String valueRemuve(String w) {
        int a = 0;
        String z = null;
        if (w.contains("=")) {
            char[] c = w.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '=')
                    a = i;
            }
            z = w.substring(0, a);
        }
        else
            z = w;
        return z;
    }
    public static ArrayList<String> listRemuveValue(ArrayList<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            list1.add(valueRemuve(s));
        }
        return list1;
    }
    public static ArrayList<String> ObjValue(ArrayList<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("obj")) {
                char[] c = list.get(i).toCharArray();
                int a = 0;
                for (int j = 0; j < c.length; j++) {
                    if (c[j] == '=') {
                        a = j + 1;
                    }
                }
                list1.add(list.get(i).substring(a));
            }
        }
        return list1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        ArrayList<String> list = Solution.list(s);
        ArrayList<String> listObj = list;
        list = Solution.listRemuveValue(list);
        Solution.listPrint(list);
        listObj = Solution.ObjValue(listObj);

        double d;
        for (String z : listObj) {
            try {
                d = Double.parseDouble(z);
                alert(d);
            } catch (Exception e) {
                alert(z);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}