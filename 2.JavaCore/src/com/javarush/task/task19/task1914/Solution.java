package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();

        String[] re = result.split(" +");
        int a = Integer.parseInt(re[0]);
        int b = Integer.parseInt(re[2]);

        int c = 0;
        if (re[1].equals("+")) {
            c = a + b;
        } else if (re[1].equals("-")) {
            c = a - b;
        } else if (re[1].equals("*")) {
            c = a * b;
        }
        System.out.println(a + " " + re[1] + " " + b + " " + re[3] + " " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}