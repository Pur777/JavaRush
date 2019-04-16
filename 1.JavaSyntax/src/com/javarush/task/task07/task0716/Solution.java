package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean a = list.get(i).contains("р");
            boolean b = list.get(i).contains("л");
            if ((a && b) || (!a && !b))
                list2.add(0,list.get(i));
            else if (b) {
                list2.add(0,list.get(i));
                list2.add(0,list.get(i));
            }
        }
        return list2;
    }
}