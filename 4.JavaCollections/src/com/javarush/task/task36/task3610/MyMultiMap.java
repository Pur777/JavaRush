package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Map.Entry<K, List<V>> pair : map.entrySet()) {
            size += pair.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if (!map.containsKey(key)) {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        V v;
        if (map.get(key).isEmpty()) {
            v = null;
        } else {
            v = map.get(key).get(map.get(key).size() - 1);
        }

        if(map.get(key).size() < repeatCount) {
            map.get(key).add(value);
        } else if (map.get(key).size() == repeatCount) {
            map.get(key).remove(0);
            map.get(key).add(value);
        }
        return v;
    }

    @Override
    public V remove(Object key) {
        V v = null;
        if (!map.containsKey(key)) {
            return null;
        }

        if (!map.get(key).isEmpty()) {
            v = map.get(key).remove(0);

        }
        if (map.get(key).isEmpty()) {
            map.remove(key);
        }
        return v;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for (Map.Entry<K, List<V>> pair : map.entrySet()) {
            list.addAll(pair.getValue());
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, List<V>> pair : map.entrySet()) {
            for (V v : pair.getValue()) {
                if (v.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}