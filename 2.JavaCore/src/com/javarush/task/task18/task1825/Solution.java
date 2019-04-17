package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileName = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        ArrayList<Integer> data = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (; true;) {
            String s = reader.readLine();
            if (s.equals("end"))
                break;
            fileName.add(s);
        }

        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < fileName.size(); j++) {
            int k = 0;
            for (String s : fileName.get(j).split("\\.")) {
                if ((k < fileName.get(j).split("\\.").length - 1) && j == 0) {
                    list.add(s);
                }
                if (k == fileName.get(j).split("\\.").length - 1) {
                    sequence.add(Integer.parseInt(s.substring(4)));
                }
                k++;
            }
        }

        String fileN = fileName.get(0);
        String[] resultFile = fileN.split(".part");
        String outputFileName = resultFile[0];

        for (int i = 0; i < sequence.size() - 1; i++) {
            for (int j = 0; j < sequence.size() - 1; j++) {
                if (sequence.get(j) > sequence.get(j + 1)) {
                    Collections.swap(sequence, j, j + 1);
                    Collections.swap(fileName, j, j + 1);
                }
            }
        }
        ArrayList<InputStream> in = new ArrayList<>();
        for (String s : fileName) {
            in.add(new FileInputStream(s));
        }
        ArrayList<BufferedInputStream> inBuff = new ArrayList<>();
        for (InputStream i : in) {
            inBuff.add(new BufferedInputStream(i));
        }

        for (BufferedInputStream i : inBuff) {
            while (i.available() > 0) {
                int a = i.read();
                data.add(a);
            }
        }

        OutputStream outputStream = new FileOutputStream(outputFileName);
        for (int a : data) {
            outputStream.write(a);
        }



        for (int i = 0; i < inBuff.size(); i++) {
            inBuff.get(i).close();
            in.get(i).close();
        }
        outputStream.close();
    }
}