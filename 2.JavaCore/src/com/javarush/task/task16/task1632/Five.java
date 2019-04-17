package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Five extends Thread{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> numb = new ArrayList<>();
    @Override
    public void run() {
        for (; true;) {
            try {
                String s = reader.readLine();
                if (s.equals("N"))
                    break;
                numb.add(Integer.parseInt(s));
            } catch (IOException e) {

            }
        }
        System.out.println(numb.stream().mapToInt(Integer::intValue).sum());
    }
}
