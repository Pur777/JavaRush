package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
//
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
                throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws IOException{
                throw new NotSerializableException();
            }
    }

    public static void main(String[] args) throws IOException {
        SubSolution solution = new SubSolution();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\One"));
        objectOutputStream.writeObject(solution);
    }
}