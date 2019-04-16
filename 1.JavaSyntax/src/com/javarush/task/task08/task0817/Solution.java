package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> xxx = new HashMap<>();
        xxx.put("Петечкин", "Николай");
        xxx.put("Иванов", "Иван");
        xxx.put("Петров", "Петр");
        xxx.put("Алексеев", "Алексей");
        xxx.put("Николаев", "Петр");
        xxx.put("Писечкин", "Федр");
        xxx.put("Камушкин", "Константин");
        xxx.put("Пипеткин", "Валентин");
        xxx.put("Пес", "Собака");
        xxx.put("Нахер", "Николай");
        return xxx;
    }
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {

        ArrayList<String> pes = new ArrayList<>(map.values());
        ArrayList<String> pes2 = new ArrayList<>();

        for (int j = 1; j < pes.size(); j++) {
            for (int i = 0; i < pes.size(); i++) {
                if (pes.get(j).equals(pes.get(i)) && i != j)
                    pes2.add(pes.get(i));
            }
        }
        for (int i = 0; i < pes2.size(); i++) {
            String c = pes2.get(i);
            removeItemFromMapByValue(map, c);
        }
    }
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {

        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
    public static void main(String[] args) {
    }
}