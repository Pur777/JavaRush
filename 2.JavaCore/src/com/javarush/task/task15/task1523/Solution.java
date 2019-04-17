package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private Solution(int a){}
    protected Solution(String a){}
    Solution(int a, String b){}
    public Solution(){}
    public static void main(String[] args) {

    }
}