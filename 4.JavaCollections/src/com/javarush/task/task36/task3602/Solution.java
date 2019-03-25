package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class clazz = Collections.class;
        Class[] declaredClasses = clazz.getDeclaredClasses();
        List<Class> needList = new ArrayList<>();

        for (Class c : declaredClasses) {
            int a = c.getModifiers();
            if (Modifier.isPrivate(a) && Modifier.isStatic(a) && c.getSuperclass().getSimpleName().equals("AbstractList")){
                needList.add(c);
            }
        }

        return needList.get(1);
    }
}