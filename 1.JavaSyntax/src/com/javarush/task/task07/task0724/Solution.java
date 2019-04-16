package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human human = new Human("Аня", false, 43);
        Human human2 = new Human("Вадим", true, 45);
        Human human3 = new Human("Денис", true, 37);
        Human human4 = new Human("Бен", true, 67);
        Human human5 = new Human("Элли", false, 21, human2, human);
        Human human6 = new Human("Петр", true, 19, human3, human);
        Human human7 = new Human("Юля", false, 21, human6, human5);
        Human human8 = new Human("Оля", false, 21, human2, human7);
        Human human9 = new Human("Евгений", true, 21, human4, human8);
        System.out.println(human.toString());
        System.out.println(human2.toString());
        System.out.println(human3.toString());
        System.out.println(human4.toString());
        System.out.println(human5.toString());
        System.out.println(human6.toString());
        System.out.println(human7.toString());
        System.out.println(human8.toString());
        System.out.println(human9.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}