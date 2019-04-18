package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String test[] = new String[3];
        test[0] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        test[1] = test[0].toLowerCase();
        test[2] = "0123456789";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 3; i++) {
            int random1 = (int)(Math.random() * test[0].length());
            int random2 = (int)(Math.random() * test[0].length());
            outputStream.write(test[0].charAt(random1));
            outputStream.write(test[1].charAt(random2));
        }
        outputStream.write(test[2].charAt((int)(Math.random() * test[2].length())));
        outputStream.write(test[2].charAt((int)(Math.random() * test[2].length())));
        return outputStream;
    }
}