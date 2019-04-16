package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        for (int n = 0; n < 10; n++)
            System.out.println(name + " любит меня.");

    }
}