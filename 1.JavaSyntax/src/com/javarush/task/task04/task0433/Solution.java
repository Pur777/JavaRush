package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int n = 0;
        while (n < 10) {
            int m = 0;
            while (m < 10) {
                m++;
                System.out.print("S");
            }
            System.out.println();
            n++;
        }
    }
}