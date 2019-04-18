package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        List<String> listTest = Arrays.asList("Ben", "Tom", "Ben");
        List<Long> listID = new ArrayList<>();
        for (String s : listTest) {
            listID.add(shortener.getId(s));
        }
        Assert.assertNotEquals(listID.get(0), listID.get(1));
        Assert.assertNotEquals(listID.get(2), listID.get(1));
        Assert.assertEquals(listID.get(0), listID.get(2));

        List<String> stringList = new ArrayList<>();
        for (Long l : listID) {
            stringList.add(shortener.getString(l));
        }

        Assert.assertEquals(listTest.get(0), stringList.get(0));
        Assert.assertEquals(listTest.get(1), stringList.get(1));
        Assert.assertEquals(listTest.get(2), stringList.get(2));
    }
    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
//14.3. Добавь класс FunctionalTest в пакет tests. В этом классе мы проверим функциональность наших стратегий.
//14.4. Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он должен:
//14.4.1. Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
//14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
//14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
//
//Подсказка: метод Assert.assertNotEquals.
//
//14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.
//
//Подсказка: метод Assert.assertEquals.
//
//14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
//14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
//
//Подсказка: метод Assert.assertEquals.
//
//14.5. Добавь в класс FunctionalTest тесты:
//14.5.1. testHashMapStorageStrategy()
//14.5.2. testOurHashMapStorageStrategy()
//14.5.3. testFileStorageStrategy()
//14.5.4. testHashBiMapStorageStrategy()
//14.5.5. testDualHashBidiMapStorageStrategy()
//14.5.6. testOurHashBiMapStorageStrategy()
//Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию, создавать объект класса Shortener на базе этой
// стратегии и вызывать метод testStorage для него.
//Запусти и проверь, что все тесты проходят.
//
//
//Требования:
//1. Класс FunctionalTest должен быть добавлен в созданный пакет tests.
//2. В методе testStorage должны быть трижды вызваны методы getId и getString.
//3. Тестовые методы перечисленные в условии задачи должны быть отмечены только аннотацией @Test.
//4. В каждом тестовом методе должен содержаться вызов метода testStorage.
