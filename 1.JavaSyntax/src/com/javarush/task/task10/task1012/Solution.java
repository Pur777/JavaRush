package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer> abcd = new ArrayList<>();
        ArrayList<Character> sobaka = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            abcd.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            char[] x = list.get(i).toCharArray();
            for (int j = 0; j < x.length; j++) {
                sobaka.add(x[j]);
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            for (int k = 0; k < sobaka.size(); k++) {
                if (alphabet.get(i).equals(sobaka.get(k)))
                    abcd.set(i, abcd.get(i)+1);
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + abcd.get(i));
        }
    }
}