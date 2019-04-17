package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String z = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            z = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(z))) {
            String s;
            while ((s = reader.readLine()) != null) {
                char[] a = s.toCharArray();
                s = "";
                for (int i = a.length - 1; i >= 0; i--) {
                    s += a[i];
                }
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : data) {
            System.out.println(s);
        }
    }
}