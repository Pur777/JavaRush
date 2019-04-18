package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public int indexFor(int hash, int length){
        return 0;
    }
    public Entry getEntry(Long key){
        for (Entry e : table) {
            if (e.key.equals(key)) {
                return e;
            }
        }
        return null;
    }
    public void resize(int newCapacity){
        Entry[] oldTab = table;
        table = new Entry[newCapacity];
        for (int i = 0; i < oldTab.length; i++) {
            table[i] = oldTab[i];
        }
    }
    public void transfer(Entry[] newTable){}
    public void addEntry(int hash, Long key, String value, int bucketIndex){}
    public void createEntry(int hash, Long key, String value, int bucketIndex){
    }
    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab;
        if ((tab = table) != null && size > 0) {
            for (Entry e : tab) {
                for (; e != null; e = e.next) {
                    if (e.value.equals(value))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                table[i] = new Entry(hash(key), key, value, null);
                size++;
                break;
            } else if (i == table.length - 1 && table[i] != null) {
                resize(table.length + 1);
                table[table.length - 1] = new Entry(hash(key), key, value, null);
                size++;
                break;
            }
        }


    }

    @Override
    public Long getKey(String value) {
        Entry[] tab;
        if ((tab = table) != null && size > 0) {
            for (Entry e : tab) {
                for (; e != null; e = e.next) {
                    if (e.value.equals(value))
                        return e.key;
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry e;
        return (e = getEntry(key)) == null ? null : e.value;
    }
}
