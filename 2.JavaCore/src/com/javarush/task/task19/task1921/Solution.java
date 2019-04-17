package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> data = solution.getData(args[0]);
        for (String s : data) {
            PEOPLE.add(solution.getPerson(s));
        }
    }

    public ArrayList<String> getData(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Person getPerson(String dat) {
        String[] ss = dat.split(" +");
        String name = "";
        for (int i = 0; i < ss.length - 3; i++) {
            name += ss[i] + " ";
        }
        String date = ss[ss.length - 3] + " " + ss[ss.length - 2] + " " + ss[ss.length - 1];
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date date1 = null;
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Person(name.trim(), date1);
    }
}