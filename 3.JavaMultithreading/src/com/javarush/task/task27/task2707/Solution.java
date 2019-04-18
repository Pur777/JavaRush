package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        };
        thread1.start();
        Thread.sleep(1000);
        thread2.setDaemon(true);
        thread2.start();
        Thread.sleep(500);
        boolean x = thread2.getState() == Thread.State.BLOCKED;
        if (thread2.getState() == Thread.State.TIMED_WAITING) {
            thread2.interrupt();
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o2, o1));

    }
}