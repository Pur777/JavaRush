package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null) {
            return 0;
        }
        char[] z = s.toCharArray();
        Set<Character> string = new HashSet<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < z.length; i++) {
            if (string.isEmpty()) {
                string.add(z[i]);
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                if (!string.contains(z[i])) {
                    string.add(z[i]);
                    count++;
                    if (max < count) {
                        max = count;
                    }
                } else {
                    i -= count - 1;
                    count = 0;
                    string.clear();
                    string.add(z[i]);
                    count++;
                }
            }
        }
        return max;
    }
}
