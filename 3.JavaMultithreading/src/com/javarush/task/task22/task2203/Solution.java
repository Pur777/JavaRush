package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
            if (string == null) {
                throw new TooShortStringException();
            }
            int a = string.indexOf('\t');
            a = string.indexOf('\t', a + 1);
            if (a == -1) {
                throw new TooShortStringException();
            }
        String z = string.substring(string.indexOf('\t') + 1, string.indexOf('\t', a));
        return z;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}