package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        String z = reader.readLine();
        InputStream inputStream = new FileInputStream(y);
        OutputStream outputStream = new FileOutputStream(z);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        ArrayList<Double> numb = new ArrayList<>();
        ArrayList<Integer> numbInt = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            String[] a = s.split(" ");
            for (int i = 0; i < a.length; i++) {
                numb.add(Double.parseDouble(a[i]));
            }
        }
        for (Double a : numb) {
            numbInt.add((int)Math.round(a));
        }
        for(Integer d : numbInt) {
            String a = d + " ";
            outputStream.write(a.getBytes());
        }


        inputStream.close();
        outputStream.close();
        reader.close();

    }
}