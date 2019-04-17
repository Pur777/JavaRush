package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inStream = new FileInputStream(s);
        BufferedReader xxx = new BufferedReader(new InputStreamReader(inStream));
        ArrayList<Integer> list = new ArrayList<>();
        String w;
        int a;
        while ((w = xxx.readLine()) != null) {
            a = Integer.parseInt(w);
            list.add(a);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                System.out.println(list.get(i));
        }
        inStream.close();
        reader.close();
        xxx.close();
    }
}