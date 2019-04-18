package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread tt;

    public LoggingStateThread(Thread thread) {
        this.tt = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(tt.getState());
        State state = this.tt.getState();
        while (state != State.TERMINATED) {
            if (state != this.tt.getState()) {
                state = this.tt.getState();
                System.out.println(state);
            }
        }
    }
}