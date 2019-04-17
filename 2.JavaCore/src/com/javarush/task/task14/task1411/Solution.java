package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution implements Person {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> keys = new ArrayList<>();
        for (; true;) {
            key = reader.readLine();
            if (!key.equals("user") && !key.equals("loser") && !key.equals("coder") && !key.equals("proger"))
                break;
            keys.add(key);
        }
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals("user"))
                persons.add(new User());
            else if (keys.get(i).equals("loser"))
                persons.add(new Loser());
            else if (keys.get(i).equals("coder"))
                persons.add(new Coder());
            else if (keys.get(i).equals("proger"))
                persons.add(new Proger());
        }

        for (Person x : persons) {
            doWork(x);
        }
    }

    public static void doWork(Person person) {
        if (person instanceof User)
            ((User) person).live();
        else if (person instanceof Loser)
            ((Loser) person).doNothing();
        else if (person instanceof Coder)
            ((Coder) person).writeCode();
        else if (person instanceof Proger)
            ((Proger) person).enjoy();
    }
}