package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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
        String ste = outputStream.toString();
        String[] ss = ste.split("\n");
        System.setOut(consoleStream);
        for (int i = 0; i < ss.length; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(ss[i]);
            } else
                System.out.println(ss[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}