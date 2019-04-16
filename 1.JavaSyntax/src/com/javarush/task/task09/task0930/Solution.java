package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.String.valueOf;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> numb = new ArrayList<>();
        ArrayList<Integer> numbCopy = new ArrayList<>();
        ArrayList<String> stroka = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i]))
                numb.add(array[i]);
            else
                stroka.add(array[i]);
        }
        for (int i = 0; i < numb.size(); i++) {
            numbCopy.add(Integer.parseInt(numb.get(i)));
        }
        Collections.sort(numbCopy);
        Collections.reverse(numbCopy);
        for (int i = 0; i < numb.size(); i++) {
            numb.set(i, valueOf(numbCopy.get(i)));
        }
        for (int j = 0; j < stroka.size() - 1; j++) {
            for (int i = 0; i < stroka.size() - 1; i++) {
                if (isGreaterThan(stroka.get(i), stroka.get(i + 1)))
                    Collections.swap(stroka, i, i + 1);
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = numb.get(a);
                a++;
            }
            else {
                array[i] = stroka.get(b);
                b++;
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}