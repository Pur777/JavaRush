package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String, Cat> xxxmap = new HashMap<>();
        xxxmap.put("Cat1", new Cat("Cat1"));
        xxxmap.put("Cat2", new Cat("Cat2"));
        xxxmap.put("Cat3", new Cat("Cat3"));
        xxxmap.put("Cat4", new Cat("Cat4"));
        xxxmap.put("Cat5", new Cat("Cat5"));
        xxxmap.put("Cat6", new Cat("Cat6"));
        xxxmap.put("Cat7", new Cat("Cat7"));
        xxxmap.put("Cat8", new Cat("Cat8"));
        xxxmap.put("Cat9", new Cat("Cat9"));
        xxxmap.put("Cat10", new Cat("Cat10"));
        return xxxmap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        HashSet<Cat> yyyset = new HashSet<>();
        for (HashMap.Entry<String, Cat> pair : map.entrySet()) {
            yyyset.add(pair.getValue());
        }
        return yyyset;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}