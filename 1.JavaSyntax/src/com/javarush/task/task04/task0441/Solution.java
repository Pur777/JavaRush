package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d;
        if ((a <= b && a >= c) || (a <= c && a >= b))
            d = a;
        else if ((b <= a && b >= c) || (b <= c && b >= a))
            d = b;
        else
            d = c;
        System.out.println(d);
    }
}