package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Object();
        String s = (String) object;
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.length();
    }

    public static void main(String[] args) {

    }
}
