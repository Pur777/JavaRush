package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        String m = trace[2].getMethodName();
        String c = trace[2].getClassName();
        System.out.println(c + ": " + m + ": " + s);
    }
}