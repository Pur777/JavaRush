package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(23, 1.16));
        System.out.println(convertEurToUsd(54, 1.17));
    }

    public static double convertEurToUsd(int eur, double course) {
        return eur * course;
    }
}