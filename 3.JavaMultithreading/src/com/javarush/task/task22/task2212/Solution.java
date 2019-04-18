package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber != null) {
            int count = 0;
            char[] c = telNumber.toCharArray();
            for (char d : c) {
                if (Character.isDigit(d)){
                    count++;
                }
            }
            if (count == 10) {
                Pattern pat1 = Pattern.compile("(\\(\\d{3}\\))?\\d+\\-?\\d+\\-?\\d+");
                Matcher mat1 = pat1.matcher(telNumber);
                return mat1.matches();
            }
            else if (count == 12) {
                Pattern pat2 = Pattern.compile("\\+\\d+(\\(\\d{3}\\))?\\-?\\d+\\-?\\d+");
                Matcher mat2 = pat2.matcher(telNumber);
                return mat2.matches();
            } else return false;

        } else return false;
    }

    public static void main(String[] args) {
        String s[] = {"+380501234567", "+38(050)1234567", "+38050123-45-67", "050123-4567", "+38)050(1234567",
                "+38(050)1-23-45-6-7", "050ххх4567", "050123456", "(0)501234567", null};
        for (String x : s) {
            System.out.println(checkTelNumber(x));
        }
    }
}