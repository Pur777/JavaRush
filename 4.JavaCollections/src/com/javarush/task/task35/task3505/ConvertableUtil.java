package com.javarush.task.task35.task3505;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static<V, K> Map convert(List<V> list) {
        Map <K, V>result = new HashMap();

        for (V t : list) {
            try {
                Class clazz = t.getClass();
                Method method = clazz.getDeclaredMethod("getKey", null);
                K key = (K)method.invoke(t, null);
                result.put(key, t);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
