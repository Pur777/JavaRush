package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        if (e == null) {
            return;
        } else {
            uncaughtException(this, e.getCause());
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        } catch (Exception e) {
            uncaughtException(this, e);
            interrupt();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();

    }
}