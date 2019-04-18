package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int a;
        int z = Integer.parseInt("10", 2);
        try {
            a = Integer.decode(s);
        } catch (NumberFormatException e) {
            a = Integer.parseInt(s.substring(2), 2);
        }
        return String.valueOf(a);
    }
}