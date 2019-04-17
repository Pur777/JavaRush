package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void ccc(String s) throws ParseException {
        String w = s.substring(3);
        ArrayList<String> list = new ArrayList<>();
        for (String d : w.split(" ")) {
            list.add(d);
        }
        DateFormat fo = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date xxx = fo.parse(list.get(2));
        if (list.get(1).equals("м"))
            allPeople.add(Person.createMale(list.get(0), xxx));
        if (list.get(1).equals("ж"))
            allPeople.add(Person.createFemale(list.get(0), xxx));
        int a = 0;
        for (int i = 0; i < allPeople.size(); i++) {
            if (allPeople.get(i).getName().equals(list.get(0)))
                a = i;
        }
        System.out.println(a);
    }
    public static void uuu(String s) throws ParseException {
        String w = s.substring(3);
        ArrayList<String> list = new ArrayList<>();
        for (String d : w.split(" ")) {
            list.add(d);
        }
        DateFormat fo = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date xxx = fo.parse(list.get(3));
        if (list.get(2).equals("м"))
            allPeople.set(Integer.parseInt(list.get(0)), Person.createMale(list.get(1), xxx));
        if (list.get(2).equals("ж"))
            allPeople.add(Integer.parseInt(list.get(0)), Person.createFemale(list.get(1), xxx));
    }
    public static void ddd(String s){
        int w = Integer.parseInt(s.substring(3).trim());
        Person person = Person.createMale(null,null);
        person.setSex(null);
        allPeople.set(w, person);
    }
    public static void iii(String s){
        int w = Integer.parseInt(s.substring(3).trim());
        Person person = allPeople.get(w);
        DateFormat fo = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String b;
        if (String.valueOf(person.getSex()).equals("FEMALE"))
            b = "ж";
        else
            b = "м";
        System.out.println(person.getName() + " " + b + " " + fo.format(person.getBirthDate()));
    }

    public static void main(String[] args) throws ParseException {
        String x = "";
        for (String a : args) {
            x += a + " ";
        }
            if (x.contains("-c")) {
                ccc(x);
            } else if (x.contains("-u")) {
                uuu(x);
            } else if (x.contains("-d")) {
                ddd(x);
            } else if (x.contains("-i")) {
                iii(x);
            }
    }
}