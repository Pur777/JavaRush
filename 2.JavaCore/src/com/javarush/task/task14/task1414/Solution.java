package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> keys = new ArrayList<>();
        for (; true;) {
            String s = reader.readLine();
            keys.add(s);
            if (!s.equals("soapOpera") && !s.equals("cartoon") && !s.equals("thriller"))
                break;

        }
        ArrayList<Movie> movies = new ArrayList<>();
        for (String x : keys) {
            movies.add(MovieFactory.getMovie(x));
        }

        for (Movie m : movies) {
            if (m instanceof SoapOpera || m instanceof Cartoon || m instanceof Thriller)
            System.out.println(m.getClass().getSimpleName());
        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = new Movie() ;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key))
                movie = new Cartoon();
            if ("thriller".equals(key))
                movie = new Thriller();

            return movie;
        }
    }

    static class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{}
    static class Thriller extends Movie{}

}