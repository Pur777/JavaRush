package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> pes = new HashMap<>();
        pes.put("арбуз", "ягода");
        pes.put("банан", "трава");
        pes.put("вишня", "ягода");
        pes.put("груша", "фрукт");
        pes.put("дыня", "овощ");
        pes.put("ежевика", "куст");
        pes.put("жень-шень", "корень");
        pes.put("земляника", "ягода");
        pes.put("ирис", "цветок");
        pes.put("картофель", "клубень");
        for (Map.Entry<String, String> pair : pes.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}