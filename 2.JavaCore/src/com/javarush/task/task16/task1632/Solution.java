package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new One());
        threads.add(new Two());
        threads.add(new Three());
        threads.add(new For());
        threads.add(new Five());
    }
    public static void main(String[] args) {
    }
}