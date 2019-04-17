package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); // чтение содержимого файла
        String strLine;
        char[] c;
        ArrayList<Character> ca = new ArrayList<>();
        while ((strLine = br.readLine()) != null){
            c = strLine.toCharArray();
            for (int i = 0; i <c.length; i++) {
                ca.add(c[i]);
            }
        }
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = alpha + alpha.toLowerCase();
        c = alphabet.toCharArray();
        int count = 0;
        for (Character a : ca) {
            for (Character b : c) {
                if (a.equals(b))
                    count++;
            }
        }
        System.out.println(count);
        inputStream.close();
        br.close();
    }
}