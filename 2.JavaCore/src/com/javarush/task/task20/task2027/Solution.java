package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j', 'o', 'e', 'e', 'j', 'j'},
                {'l', 'n', 'g', 'r', 'o', 'v', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "vler");
        for (Word w : words) {
            System.out.println(w.toString());
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> fffff = new ArrayList<>();
        for (String s : words) {
            char[] ss = s.toCharArray();
            int a = 0;
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == ss[0]) {

                        if (i + ss.length <= crossword.length && j - (ss.length - 1) >= 0) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;

                            int ii = i;
                            int jj = j;
                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii++;
                                jj--;
                            }
                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }
                        if (i - (ss.length - 1) >= 0 && j + ss.length <= crossword[i].length) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;

                            int ii = i;
                            int jj = j;
                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii--;
                                jj++;
                            }
                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }

                        if (j + ss.length <= crossword[i].length) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;


                            int ii = i;
                            int jj = j;

                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                jj++;
                            }

                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }
                        if (i + ss.length <= crossword.length) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;


                            int ii = i;
                            int jj = j;

                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii++;
                            }

                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }
                        if (i + ss.length <= crossword.length && j + ss.length <= crossword[i].length) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;

                            int ii = i;
                            int jj = j;

                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii++;
                                jj++;
                            }
                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }

                        if (j - (ss.length - 1) >= 0) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;


                            int ii = i;
                            int jj = j;

                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                jj--;
                            }

                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }
                        if (i - (ss.length - 1) >= 0) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;


                            int ii = i;
                            int jj = j;

                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii--;
                            }

                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }
                        if (j - (ss.length - 1) >= 0 && i - (ss.length - 1) >= 0) {
                            char[] slovo = new char[ss.length];

                            int startI = 0;
                            int startJ = 0;
                            int endI = 0;
                            int endJ = 0;

                            int ii = i;
                            int jj = j;
                            for (int k = 0; k < slovo.length; k++) {
                                slovo[k] = (char)crossword[ii][jj];
                                if (k == 0) {
                                    startI = ii;
                                    startJ = jj;
                                }
                                if (k == slovo.length - 1) {
                                    endI = ii;
                                    endJ = jj;
                                }
                                ii--;
                                jj--;
                            }
                            if (s.equals(new String(slovo))) {
                                Word word = new Word(s);
                                word.setStartPoint(startJ, startI);
                                word.setEndPoint(endJ, endI);
                                fffff.add(word);
                            }
                        }


                    }
                }
            }

        }
        return fffff;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}