package com.javarush.task.task16.task1632;

public class For extends Thread implements Message{
public static boolean b = true;
    @Override
    public void run() {
        for (;b;){
        }
    }

    @Override
    public void showWarning()  {
        b = false;
    }

}