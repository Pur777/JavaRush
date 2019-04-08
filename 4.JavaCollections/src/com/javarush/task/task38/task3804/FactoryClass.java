package com.javarush.task.task38.task3804;

public class FactoryClass {
    public static<T> Throwable getException(T t) {
        String message = null;
        if (t != null) {
            message = t.toString().substring(0, 1) + t.toString().substring(1).toLowerCase().replaceAll("_", " ");
        }
        if (t instanceof ApplicationExceptionMessage) {
            return new Exception(message);
        } else if (t instanceof UserExceptionMessage) {
            return new Error(message);
        } else if (t instanceof DatabaseExceptionMessage) {
            return new RuntimeException(message);
        } else {
            return new IllegalArgumentException();
        }
    }
}
