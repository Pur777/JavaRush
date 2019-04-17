package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static synchronized void ccc(ArrayList<String> options) throws ParseException {
        options.remove(0);

        int a = options.size() / 3;
        DateFormat fo = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 0; i < (options.size() - 2); i += 3) {
            Date xxx = fo.parse(options.get(i + 2));
            if (options.get(i + 1).equals("м"))
                allPeople.add(Person.createMale(options.get(i), xxx));
            if (options.get(i + 1).equals("ж"))
                allPeople.add(Person.createFemale(options.get(i), xxx));
        }

        for (int i = allPeople.size() - a; i < allPeople.size(); i++) {
            System.out.println(i);
        }

    }
    public static synchronized void uuu(ArrayList<String> options) throws ParseException {
        options.remove(0);

        DateFormat fo = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 0; i < (options.size() - 3); i += 4) {
            Date xxx = fo.parse(options.get(i + 3));
            if (options.get(i + 2).equals("м"))
                allPeople.set(Integer.parseInt(options.get(i)), Person.createMale(options.get(i + 1), xxx));
            if (options.get(i + 2).equals("ж"))
                allPeople.set(Integer.parseInt(options.get(i)), Person.createFemale(options.get(i + 1), xxx));
        }
    }
    public static synchronized void ddd(ArrayList<String> options){
        options.remove(0);
        ArrayList<Integer> index = new ArrayList<>();
        for (String s : options) {
            index.add(Integer.parseInt(s));
        }
        Person person = Person.createMale(null,null);
        person.setSex(null);
        for (Integer i : index) {
            allPeople.set(i, person);
        }
    }
    public static synchronized void iii(ArrayList<String> options) {
        options.remove(0);
        ArrayList<Integer> index = new ArrayList<>();
        for (String s : options) {
            index.add(Integer.parseInt(s));
        }
        DateFormat fo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Integer i : index) {
            Person person = allPeople.get(i);
            String b;
            if (String.valueOf(person.getSex()).equals("FEMALE"))
                b = "ж";
            else
                b = "м";
            System.out.println(person.getName() + " " + b + " " + fo.format(person.getBirthDate()));
        }
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<String> list = new ArrayList<>();
        for (String s : args) {
            list.add(s);
        }

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    allPeople = allPeople;
                }
                ccc(list);
                break;
            case "-u":
                synchronized (allPeople) {
                    allPeople = allPeople;
                }
                uuu(list);
                break;
            case "-d":
                synchronized (allPeople) {
                    allPeople = allPeople;
                }
                ddd(list);
                break;
            case "-i":
                synchronized (allPeople) {
                    allPeople = allPeople;
                }
                iii(list);
                break;
        }
    }
}