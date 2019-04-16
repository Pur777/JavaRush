package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dog = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dog.add(Integer.parseInt(reader.readLine()));
        }
        int max = 0;
        int a = 1;
        for (int i = 0; i < (dog.size() - 1); i++) {
            if (dog.get(i).equals(dog.get(i + 1)))
                a++;
            else
                a = 1;
            if (max < a)
                max = a;
        }
        System.out.println(max);
    }
}