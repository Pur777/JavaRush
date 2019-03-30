package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> romanNumb = new HashMap<>();
        romanNumb.put('I', 1);
        romanNumb.put('V', 5);
        romanNumb.put('X', 10);
        romanNumb.put('L', 50);
        romanNumb.put('C', 100);
        romanNumb.put('D', 500);
        romanNumb.put('M', 1000);
        char[] numbChar = s.toCharArray();

        if (numbChar.length == 1) {
            return romanNumb.get(numbChar[0]);

        } else {
            int intNumb = 0;
            for (int i = 0; i < numbChar.length; i++) {
                int before = romanNumb.get(numbChar[i]);
                int after;
                if ((i + 1) < numbChar.length) {
                    after = romanNumb.get(numbChar[i + 1]);
                } else {
                    after = 0;
                }

                int a;
                if (before < after) {
                    a = after - before;
                    i++;
                } else {
                    a = before;
                }
                intNumb += a;
            }
            return intNumb;
        }
    }
}