package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        String resultFileName = args[0];
        List<Path> pathList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            pathList.add(Paths.get(args[i]));
        }
        pathList.sort(Comparator.comparing(Path::toString));

        try {
            List<InputStream> fisList = new ArrayList<>();
            for (Path p : pathList) {
                fisList.add(Files.newInputStream(p));
            }

            try (SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
                 ZipInputStream zipInStream = new ZipInputStream(seqInStream);
                 FileOutputStream fileOutputStream = new FileOutputStream(resultFileName)) {
                byte[] buffer = new byte[1024 * 1024];

                while (zipInStream.getNextEntry() != null) {
                    int len;
                    while ((len = zipInStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
