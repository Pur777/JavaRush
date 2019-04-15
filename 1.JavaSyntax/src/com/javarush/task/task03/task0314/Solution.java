package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("1 2 3 4 5 6 7 8 9 10");
        int n = 1;
        while (n < 10) {
            n++;
            int m = 1;
            while (m < 11) {

                System.out.print((n * m) + " ");
                m++;
            }
            System.out.println();
        }
    }
}