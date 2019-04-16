package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.Date;
import java.text.SimpleDateFormat;

public class Solution {
    public static void main(String[] args) {
        Date objDate = new Date();
        String strDateFormat = "dd MM yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        System.out.println(objSDF.format(objDate));
    }
}