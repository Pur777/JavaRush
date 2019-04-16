package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date xxx = fo.parse(s);
        fo = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String datestring = fo.format(xxx);
        System.out.println(datestring.toUpperCase());
    }
}