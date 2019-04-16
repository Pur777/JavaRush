package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> king = new ArrayList<>();
        ArrayList<Integer> aaa = new ArrayList<>();
        ArrayList<Integer> bb = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            king.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < king.size(); i++) {
            Integer x = king.get(i);
            if (x % 3 == 0)
                aaa.add(x);
            if (x % 2 == 0)
                bb.add(x);
            if (x % 3 != 0 && x % 2 != 0)
                c.add(x);
        }
        printList(aaa);
        printList(bb);
        printList(c);
    }



    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}