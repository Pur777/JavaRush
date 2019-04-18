package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String name;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        }
        Path path = Paths.get(name);
        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
        } else {

            List<Path> filePath = Files.walk(path).filter(Files::isRegularFile).collect(Collectors.toList());

            List<Path> directoryFile = Files.walk(path).filter(Files::isDirectory).collect(Collectors.toList());

            long size = 0;

            for (Path p : filePath) {
                size += Files.size(p);
            }
            System.out.println("Всего папок - " + (directoryFile.size() - 1));
            System.out.println("Всего файлов - " + filePath.size());
            System.out.println("Общий размер - " + size);
        }
    }
}