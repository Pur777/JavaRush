package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Date xxx = format.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(xxx);
        boolean b;
        if (calendar.get(Calendar.DAY_OF_YEAR) % 2 == 0)
            b = false;
        else
            b = true;
        return b;
    }
}