package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Акулинцев", "Алексей");
        map.put("Рылов", "Александр");
        map.put("Кудров", "Алексей");
        map.put("Иванов", "Михаил");
        map.put("Курин", "Евгений");
        map.put("Дроздов", "Виталий");
        map.put("Соломатин", "Валентин");
        map.put("Болотин", "Алексей");
        map.put("Соколов", "Константин");
        map.put("Петров", "Петр");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (String i : map.values()) {
            if (i.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (String i: map.keySet()) {
            if(i.equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
   }
}