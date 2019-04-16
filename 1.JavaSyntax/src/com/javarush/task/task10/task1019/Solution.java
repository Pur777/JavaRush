package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> sobaka = new HashMap<>();
        int id;
        for (; true;) {
            try {
                 id = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                break;
            }
            String name = reader.readLine();
            sobaka.put(name, id);
            if (name.isEmpty())
                break;
        }

        for (Map.Entry<String, Integer> pair : sobaka.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

    }
}