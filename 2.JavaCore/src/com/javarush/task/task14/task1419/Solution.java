package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions()  {
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        try {
            throw new StringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalMonitorStateException();
        } catch (IllegalMonitorStateException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalStateException();
        } catch (IllegalStateException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalThreadStateException();
        } catch (IllegalThreadStateException e) {
            exceptions.add(e);
        }
        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new NegativeArraySizeException();
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

    }
}