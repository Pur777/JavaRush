package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread tt;

    @Override
    public void start(String threadName) {
        tt = new Thread(this);
        tt.setName(threadName);
        tt.start();
    }

    @Override
    public void stop() {
        tt.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!tt.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}