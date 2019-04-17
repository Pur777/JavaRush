package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
        }
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        public String s;
        ArrayList<String> list = new ArrayList<>();
        @Override
        public void setFileName(String fullFileName) {
            s = fullFileName;
        }
        @Override
        public String getFileContent() {
            String s = "";
            for (String w : list) {
                s += (w + " ");
            }
            return s;
        }
        public void run() {
            try {
                InputStream inStream = new FileInputStream(s);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
                String w;
                while ((w = reader.readLine()) != null){
                    list.add(w);
                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
}