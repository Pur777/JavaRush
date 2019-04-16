package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private String address;
        private int money;
        private boolean education;

        public Human(String name, int age, boolean sex, String address, int money, boolean education) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.money = money;
            this.education = education;
        }
        public Human(String name, int age, boolean sex, String address, int money) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.money = money;
        }
        public Human(String name, int age, boolean sex, String address) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }
        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Human(String name) {
            this.name = name;
        }
        public Human(String name, String address, boolean education) {
            this.name = name;
            this.address = address;
            this.education = education;
        }
        public Human(String name, int age, boolean sex, String address, boolean education) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.education = education;
        }
        public Human(int age, boolean sex, String address, int money, boolean education) {
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.money = money;
            this.education = education;
        }
        public Human(String name, boolean sex, String address) {
            this.name = name;
            this.sex = sex;
            this.address = address;
        }
    }
}