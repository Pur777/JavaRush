package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    static volatile AtomicInteger a = new AtomicInteger(1);
    public MyThread() {
        if (a.get() <= 10) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > 10){
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if (a.get() <= 10) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > 10){
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (a.get() <= group.getMaxPriority()) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > group.getMaxPriority() && a.get() <= 10) {
            a.getAndIncrement();
            this.setPriority(group.getMaxPriority());
        } else {
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }

    }

    public MyThread(String name) {
        super(name);
        if (a.get() <= 10) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > 10){
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (a.get() <= group.getMaxPriority()) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > group.getMaxPriority() && a.get() <= 10) {
            a.getAndIncrement();
            this.setPriority(group.getMaxPriority());
        } else {
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (a.get() <= 10) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > 10){
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (a.get() <= group.getMaxPriority()) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > group.getMaxPriority() && a.get() <= 10) {
            a.getAndIncrement();
            this.setPriority(group.getMaxPriority());
        } else {
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (a.get() <= group.getMaxPriority()) {
            this.setPriority(a.getAndIncrement());
        } else if (a.get() > group.getMaxPriority() && a.get() <= 10) {
            a.getAndIncrement();
            this.setPriority(group.getMaxPriority());
        } else {
            a.set(1);
            this.setPriority(a.getAndIncrement());
        }
    }
}
