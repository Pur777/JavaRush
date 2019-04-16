package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = s + s + s + s + s;
        return result;
    }

    public static String multiply(String s, int count) {
        String result = s;
        while (count > 1) {
            count--;
            result = result + s;
        }
        return result;
    }
    public static void main(String[] args) {
    }
}