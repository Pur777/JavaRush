package com.javarush.task.task16.task1632;

public class Three extends Thread{
    @Override
    public void run() {
        for (; true;) {
            try {

                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }

        }
    }
}
