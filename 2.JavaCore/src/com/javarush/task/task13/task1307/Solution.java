package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        String getInstance();
    }

    class StringObject implements SimpleObject
    {
        @Override
        public String getInstance() {
            return String.valueOf(this);
        }
    }
}
