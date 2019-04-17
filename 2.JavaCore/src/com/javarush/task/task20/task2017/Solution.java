package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) {
        A a = null;
        try {
            Object object = objectStream.readObject();
            if (object instanceof A) {
                a = (A) object;
            } else a = null;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

        return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException {

    }
}