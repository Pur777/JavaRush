package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }


    public static int method1() {
        method2();
        StackTraceElement[] Trace = Thread.currentThread().getStackTrace();
        return  Trace[2].getLineNumber();
    }

    public static int method2() {
        method3();
        StackTraceElement[] Trace = Thread.currentThread().getStackTrace();
        return  Trace[2].getLineNumber();
    }

    public static int method3() {
        method4();
        StackTraceElement[] Trace = Thread.currentThread().getStackTrace();
        return  Trace[2].getLineNumber();
    }

    public static int method4() {
        method5();
        StackTraceElement[] Trace = Thread.currentThread().getStackTrace();
        return  Trace[2].getLineNumber();
    }

    public static int method5() {
        StackTraceElement[] Trace = Thread.currentThread().getStackTrace();
        return  Trace[2].getLineNumber();
    }
}