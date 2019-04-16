package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] x = s.toCharArray();
        ArrayList<Character> xx = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            if (x[i] != ' ' )
                xx.add(x[i]);
        }
        ArrayList<Character> sog = new ArrayList<>();
        ArrayList<Character> gl = new ArrayList<>();

        for (int i = 0; i < xx.size(); i++) {
            if (isVowel(xx.get(i)) == true)
                gl.add(xx.get(i));
            else
                sog.add(xx.get(i));
        }
        for (int i = 0; i < gl.size(); i++) {
            System.out.print(gl.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < sog.size(); i++) {
            System.out.print(sog.get(i) + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}