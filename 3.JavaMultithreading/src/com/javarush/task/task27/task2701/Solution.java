package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int count = 0;
            int j = i;
            int k = 0;
            while (length-- != 0) {
                char s1 = string.charAt(j++);
                char s2 = substring.charAt(k++);
                if (s1 == s2) {
                    count++;
                    if (count == substring.length())
                        found = true;
                }
            }
        }
        return found;
    }
}
