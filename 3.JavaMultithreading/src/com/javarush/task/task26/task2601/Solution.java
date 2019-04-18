package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        ArrayList<Integer> sss = new ArrayList<>();

        for (int i : array) {
            sss.add(i);
        }
        Collections.sort(sss);
        ArrayList<Double> copy = new ArrayList<>();
        for (int i : sss) {
            copy.add((double)i);
        }

        double mediana;
        if (sss.size() % 2 == 0) {
            int x = sss.size() / 2;
            mediana = (sss.get(x) + sss.get(x - 1)) / (double)2;
        } else {
            int x = sss.size() / 2;
            mediana = sss.get(x);
        }

        for (int i = 0; i < copy.size(); i++) {
            copy.set(i, copy.get(i) - mediana);
        }

        for (int i = 0; i < copy.size() - 1; i++) {
            for (int k = 0; k < copy.size() - 1; k++) {
                if (Math.abs(copy.get(k)) > Math.abs(copy.get(k + 1))) {
                    Collections.swap(copy, k, k + 1);
                    Collections.swap(sss, k, k + 1);
                }
                else if (Math.abs(copy.get(k)) == Math.abs(copy.get(k + 1))) {
                    if (sss.get(k) > sss.get(k + 1)) {
                        Collections.swap(copy, k, k + 1);
                        Collections.swap(sss, k, k + 1);
                    }
                }
            }
        }

        for (int i = 0; i < sss.size(); i++) {
            array[i] = sss.get(i);
        }
        return array;
    }
}