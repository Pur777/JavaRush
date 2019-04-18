package com.javarush.task.task29.task2912;

public abstract class AbstractLogger implements Logger{
    int level;
    Logger next;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Logger getNext() {
        return next;
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }
}