package com.javarush.task.task18.task1812;

import java.io.IOException;

public class Decorator implements AmigoOutputStream{
    AmigoOutputStream component;
    public Decorator(AmigoOutputStream component) {
        this.component = component;
    }
    @Override
    public void flush() throws IOException {

    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {

    }

    @Override
    public void close() throws IOException {
    }
}