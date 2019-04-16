package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> xxx = new HashMap<>();
        xxx.put("Фамилия1", "Имя1");
        xxx.put("Фамилия2", "Имя2");
        xxx.put("Фамилия3", "Имя3");
        xxx.put("Фамилия4", "Имя4");
        xxx.put("Фамилия5", "Имя5");
        xxx.put("Фамилия6", "Имя6");
        xxx.put("Фамилия7", "Имя7");
        xxx.put("Фамилия8", "Имя8");
        xxx.put("Фамилия9", "Имя2");
        xxx.put("Фамилия1", "Имя9");
        return xxx;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}