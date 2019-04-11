package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("", ""));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.length() != second.length()) {
            if (first.length() - 1 != second.length()) {
                if (first.length() + 1 != second.length()) {
                    return false;
                }
            }
        }

        char[] one = first.toCharArray();
        char[] two = second.toCharArray();

        if (first.length() == second.length()) {
            return oneLength(one, two);
        } else if (first.length() < second.length()) {
            return noOneLength(one, two);
        } else {
            return noOneLength(two, one);
        }
    }

    private static boolean oneLength(char[] one, char[] second) {
        for (int i = 0; i < one.length; i++) {
            if (one[i] != second[i]) {
                one[i] = second[i];
                break;
            }
        }

        return new String(one).equals(new String(second));
    }

    private static boolean noOneLength(char[] one, char[] second) {
        try {
            int count = 0;
            for (int i = 0, k = 0; i < second.length; i++, k++) {
                if (one[k] != second[i]) {
                    count++;
                    if (count == 2) {
                        return false;
                    }
                    k--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return true;
    }
}