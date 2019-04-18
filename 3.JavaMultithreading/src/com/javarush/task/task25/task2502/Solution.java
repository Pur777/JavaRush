package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();
            if (!Arrays.asList(loadWheelNamesFromDB()).contains(Wheel.FRONT_LEFT.toString())
                    || !Arrays.asList(loadWheelNamesFromDB()).contains(Wheel.FRONT_RIGHT.toString())
                    || !Arrays.asList(loadWheelNamesFromDB()).contains(Wheel.BACK_LEFT.toString())
                    || !Arrays.asList(loadWheelNamesFromDB()).contains(Wheel.BACK_RIGHT.toString())) {
                throw new Exception();
            }
            if (loadWheelNamesFromDB().length != 4)
                throw new Exception();


            for (String s : loadWheelNamesFromDB()) {
                   wheels.add(Wheel.valueOf(s));
           }
        }

        protected String[] loadWheelNamesFromDB() {
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
    }
}