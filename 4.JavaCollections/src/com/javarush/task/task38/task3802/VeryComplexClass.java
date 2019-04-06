package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        InputStream inputStream = Files.newInputStream(Paths.get("jjj"));
        //напишите тут ваш код
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.veryComplexMethod();
    }
}

