package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> pes = new HashSet<>();
        pes.add("арбуз");
        pes.add("банан");
        pes.add("вишня");
        pes.add("груша");
        pes.add("дыня");
        pes.add("ежевика");
        pes.add("женьшень");
        pes.add("земляника");
        pes.add("ирис");
        pes.add("картофель");
        for (String s : pes) {
            System.out.println(s);
        }
    }
}