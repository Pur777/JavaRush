package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String z;
        try {
            int a = string.indexOf(' ');
            a = string.indexOf(' ', a + 1);
            a = string.indexOf(' ', a + 1);
            a = string.indexOf(' ', a + 1);
            if (a == -1) {
                throw new TooShortStringException();
            }
            a = string.indexOf(' ', a + 1);
            if (a == -1) {
                z = string.substring(string.indexOf(' ') + 1);
            } else
            z = string.substring(string.indexOf(' ') + 1, a);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return z;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}