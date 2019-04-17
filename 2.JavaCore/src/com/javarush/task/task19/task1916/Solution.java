package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String y;
        String z;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            y = reader.readLine();
            z = reader.readLine();
        }

        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(y))) {
            String s;
            while ((s = reader.readLine()) != null) {
                file1.add(s);
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(z))) {
            String s;
            while ((s = reader.readLine()) != null) {
                file2.add(s);
            }
        }

        int x;
        if (file1.size() > file2.size()) {
            x = file1.size() - file2.size();
            for (int i = 0; i < x; i++) {
                file2.add("");
            }
        }
        if (file1.size() < file2.size()) {
            x = file2.size() - file1.size();
            for (int i = 0; i < x; i++) {
                file1.add("");
            }
        }

        for (int i = 0; i < file1.size() - 1; i++) {
            if (!file1.get(i).equals(file2.get(i))) {

                if (file1.get(i).equals(file2.get(i + 1))) {
                    file1.add(i, "");
                    file2.add("");
                } if (file1.get(i + 1).equals(file2.get(i))) {
                    file2.add(i, "");
                    file1.add("");
                }
            }
        }

        for (; true;) {
            if (file1.get(file1.size() - 1).equals("") && file2.get(file2.size() - 1).equals("")) {
                file1.remove(file1.size() - 1);
                file2.remove(file2.size() - 1);
            } else
                break;
        }

        for (int i = 0; i < file1.size(); i++) {
            if (file1.get(i).equals(file2.get(i))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
            }else if (!file1.get(i).equals(file2.get(i))) {
                if (file1.get(i).equals("")) {
                    lines.add(new LineItem(Type.ADDED, file2.get(i)));
                }
                if (file2.get(i).equals("")) {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}