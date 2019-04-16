package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {

        int[] a = {2, 3, 4, 5, 6};
        int[] b = {5, 6};
        int[] c = {2, 3, 4, 6};
        int[] d = {2, 3, 4, 5, 6, 8, 9};
        int[] e = new int[0];
        ArrayList<int[]> xxx = new ArrayList<int[]>();
        xxx.add(a);
        xxx.add(b);
        xxx.add(c);
        xxx.add(d);
        xxx.add(e);
        return xxx;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}