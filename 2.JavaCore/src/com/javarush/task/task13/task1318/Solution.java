package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream inStream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
        String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
            }
        inStream.close();
        reader.close();
    }
}