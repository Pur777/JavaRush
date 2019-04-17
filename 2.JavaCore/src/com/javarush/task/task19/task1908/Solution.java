package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String y = reader.readLine();
        String z = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(y);
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                str += (char) bufferedReader.read();
            }
        bufferedReader.close();
        String[] num = str.split(" +");
        String str2 = "";
        for (String s : num) {
            try {
                str2 += Integer.parseInt(s) + " ";
            } catch (NumberFormatException e) {
            }
        }
        str2 = str2.trim();

        FileWriter fileWriter = new FileWriter(z);
        try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(str2);
        }
        fileWriter.close();

    }
}