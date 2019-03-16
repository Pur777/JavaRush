package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals((Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data").substring(1));
        System.out.println(allAnimals);
        System.out.println("Line");
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Path path = Paths.get(pathToAnimals);
        Set<Animal> animalsSet = new HashSet<>();
        try {
            List<Path> pathList = Files.walk(path).filter(Files::isRegularFile).collect(Collectors.toList());
            MyClassLoader loader = new MyClassLoader();
            for (Path p : pathList) {
                Class clazz = loader.getClassFromFile(p);
                Class[] interfaces = clazz.getInterfaces();
                Constructor[] constructors = clazz.getConstructors();
                boolean a = false;

                for (Constructor constructor : constructors) {
                    if (constructor.getParameterCount() == 0) {
                        a = true;
                    }
                }
                if (!a) {
                    continue;
                }

                for (Class i : interfaces) {
                    if (i.getSimpleName().equals("Animal")){
                        Object animal = clazz.newInstance();
                        animalsSet.add((Animal) animal);
                    }
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return animalsSet;
    }

    static class MyClassLoader extends ClassLoader {
        public Class getClassFromFile(Path file) {
            byte[] row = null;
            try {
                row = Files.readAllBytes(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Class clazz = null;
            if (row != null) {
                clazz = defineClass(null, row, 0, row.length);
            }
            return clazz;
        }
    }
}