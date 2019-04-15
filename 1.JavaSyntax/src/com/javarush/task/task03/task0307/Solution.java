package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        zerg1.name = "1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "5";
        Protoss protoss = new Protoss();
        protoss.name = "11";
        Protoss protoss2 = new Protoss();
        protoss2.name = "12";
        Protoss protoss3 = new Protoss();
        protoss3.name = "13";
        Terran terran1 = new Terran();
        terran1.name = "21";
        Terran terran2 = new Terran();
        terran2.name = "22";
        Terran terran3 = new Terran();
        terran3.name = "23";
        Terran terran4 = new Terran();
        terran4.name = "24";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}