package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        Human son1 = new Human("Василий", true, 12);
        Human son2 = new Human("Евгений", true, 10);
        Human daughter = new Human("Элии", false, 7);
        Human father = new Human("Валентин", true, 37, new ArrayList<>(Arrays.asList(son1, son2, daughter)));
        Human mother = new Human("Валентина", false, 36, new ArrayList<>(Arrays.asList(son1, son2, daughter)));
        Human grandfather1 = new Human("Борис", true, 68, new ArrayList<>(Arrays.asList(father)));
        Human grandfather2 = new Human("Петр", true, 74, new ArrayList<>(Arrays.asList(mother)));
        Human grandmother1 = new Human("Юлия", false, 66, new ArrayList<>(Arrays.asList(father)));
        Human grandmother2 = new Human("Ольга", false, 72, new ArrayList<>(Arrays.asList(mother)));
        ArrayList<Human> famili = new ArrayList<>(Arrays.asList(son1, son2, daughter, father, mother, grandfather1, grandfather2, grandmother1, grandmother2));
        for (int i = 0; i < famili.size(); i++) {
            System.out.println(famili.get(i).toString());
        }
    }
    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}