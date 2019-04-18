package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("temp", ".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void putEntry(Entry entry){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Entry getEntry(){
        if (getFileSize() == 0) {
            return null;
        }
        Entry entry = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return entry;
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//9.4. Добавь в класс методы:
//9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.
//9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
//9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
//9.4.4. void remove() - удалять файл на который указывает path.
//Конструктор и методы не должны кидать исключения.
//
//
//Требования:
//1. В классе FileBucket должно быть создано поле path типа Path.
//2. Конструктор без параметров класса FileBucket должен быть реализован в соответствии с условием задачи.
//3. Метод getFileSize должен возвращать размер файла на который указывает path.
//4. Метод putEntry должен сериализовывать полученный объект типа Entry в файл на который указывает path, чтобы
// получить OutputStream используй метод Files.newOutputStream.
//5. Метод getEntry должен десериализовывать объект типа Entry из файл на который указывает path, чтобы получить InputStream используй метод Files.newInputStream.
//6. Метод remove должен удалять файл на который указывает path с помощью метода Files.delete().
