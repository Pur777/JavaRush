package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Sobaka", df.parse("MAY 5 1990"));
        map.put("Pes", df.parse("JUNE 1 1980"));
        map.put("Cat", df.parse("MAY 1 1980"));
        map.put("Dog", df.parse("JUNE 1 1980"));
        map.put("Rabbit", df.parse("JUNE 1 1980"));
        map.put("Tigr", df.parse("JUNE 1 1980"));
        map.put("Leopard", df.parse("JUNE 1 1980"));
        map.put("Bear", df.parse("JUNE 1 1980"));
        map.put("Mouse", df.parse("JUNE 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> s = map.entrySet().iterator();

        while(s.hasNext()){
            HashMap.Entry<String, Date> t = s.next();
            if(t.getValue().getMonth() > 4 & t.getValue().getMonth() < 8){
                s.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}