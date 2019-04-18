package com.javarush.task.task34.task3410.model;

import org.junit.Test;

import java.nio.file.Paths;

public class TestClass {
    @Test
    public void readLevelsFileTest() {
        LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
        for (String s : levelLoader.readLevelsFile(61)) {
            System.out.println(s);
        }
    }

    @Test
    public void count() {
        int a = 120;
        a %= 60;
        System.out.println(a);
    }
}
