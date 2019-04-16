package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> xxx = new HashMap<>();
        xxx.put("Петров", 150);
        xxx.put("Иванов", 370);
        xxx.put("Сидоров", 502);
        xxx.put("Кудров", 550);
        xxx.put("Рылов", 120);
        xxx.put("Соломатин", 400);
        xxx.put("Ланкин", 700);
        xxx.put("Богров", 450);
        xxx.put("Махров", 690);
        xxx.put("Рукеров", 10);
        return xxx;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashSet<Integer> kkk = new HashSet<>();
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            int a = pair.getValue();
            if (a < 500)
                kkk.add(a);
        }
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            for (Integer b : kkk) {
                if (pair.getValue().equals(b))
                    map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}