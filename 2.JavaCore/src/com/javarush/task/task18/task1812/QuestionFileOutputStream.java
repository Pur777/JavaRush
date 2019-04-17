package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    public AmigoOutputStream a;

    public QuestionFileOutputStream(AmigoOutputStream a) {
        this.a = a;
    }

    @Override
    public void flush() throws IOException {
        a.flush();
    }

    @Override
    public void write(int b) throws IOException {
        a.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        a.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        a.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (reader.readLine().equals("Д")) {
            a.close();
        }

    }
}
