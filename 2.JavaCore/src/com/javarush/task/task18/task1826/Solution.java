package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> in = solution.reading(args[1]);
        if (args[0].equals("-e")) {
            solution.encryption(in);
        } else if (args[0].equals("-d")) {
            solution.decryption(in);
        }
        solution.writer(in, args[2]);
    }

    public ArrayList<Integer> reading(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(s);
            bufferedInputStream = new BufferedInputStream(inputStream);
            while (bufferedInputStream.available() > 0) {
                int a = bufferedInputStream.read();
                list.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }
    }
    public void encryption(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 2);
        }
    }
    public void decryption(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) - 2);
        }
    }
    public void writer(ArrayList<Integer> list, String s)  {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(s);
            for (int a : list) {
                outputStream.write(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}