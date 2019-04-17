package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(2.2, "a");
        labels.put(2.1, "b");
        labels.put(2.3, "c");
        labels.put(2.5, "d");
        labels.put(2.7, "e");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}