package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> nameFile = new ArrayList<>();
        for (; true;) {
            String s = reader.readLine();
            if (s.equals("exit")) {
                break;
            }
            nameFile.add(s);
        }
        for (String s : nameFile) {
            new ReadThread(s).start();
        }
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(fileName);
                ArrayList<Integer> symbol = new ArrayList<>();
                while (inputStream.available() > 0) {
                    int a = inputStream.read();
                    symbol.add(a);
                }
                Collections.sort(symbol);
                int count = 0;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < symbol.size() - 1; i++) {
                    if (symbol.get(i) == symbol.get(i + 1)) {
                        count++;
                        if (max < count) {
                            max = count;
                        }
                    }
                    else count = 0;
                }
                count = 0;
                for (int i = 0; i < symbol.size() - 1; i++) {
                    if (symbol.get(i) == symbol.get(i + 1)) {
                        count++;
                        if (max == count) {
                            resultMap.put(fileName, symbol.get(i));
                        }
                    }
                    else count = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }
}