package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] x = new Solution[2];
        for (int i = 0; i < 2; i++) {
            x[i] = new Solution();
            for (int j =0; j < x[i].innerClasses.length; j++) {
                x[i].innerClasses[j] = x[i].new InnerClass();
            }
        }
        return x;
    }

    public static void main(String[] args) {

    }
}