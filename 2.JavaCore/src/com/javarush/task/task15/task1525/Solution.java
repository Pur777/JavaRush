package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Файл в статическом блоке
*/
public class Solution {
    public static ArrayList<String> lines = new ArrayList<String>();

    static {
        try{
            FileInputStream inputStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = reader.readLine()) != null){

                lines.add(s);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}