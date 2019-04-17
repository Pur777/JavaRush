package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? date != solution1.date : solution1.date != null) return false;
        if (solution != null ? solution != solution1.solution : solution1.solution != null) return false;
        if (string != null ? string != solution1.string : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        if (string != null && date != null && solution != null) {
            return anInt + string.hashCode() + String.valueOf(aDouble).hashCode() + date.hashCode() + solution.hashCode();
        } else if (string != null && date != null) {
            return anInt + string.hashCode() + String.valueOf(aDouble).hashCode() + date.hashCode();
        } else
        return 0;
    }

    public static void main(String[] args) {
        Date date = new Date();
        Solution z = new Solution(22, "Boris", 33.9, date, null);
        Solution x = new Solution(0, "", 0d, date, null);
        Solution y = new Solution(0, "", 0d, date, null);
        System.out.println(x.hashCode() + " " + y.hashCode());
        System.out.println(x.equals(y));
    }
}