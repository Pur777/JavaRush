package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\One.txt");
        OutputStream outStream = new FileOutputStream("C:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\One.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(outStream);
        Solution saveObject = new Solution(45);
        outputStream.writeObject(saveObject);
        ObjectInputStream inStream = new ObjectInputStream(inputStream);
        Object loadedObject = inStream.readObject();
        Solution solution = (Solution) loadedObject;
        System.out.println(solution);
        System.out.println(saveObject.string.equals(solution.string));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}