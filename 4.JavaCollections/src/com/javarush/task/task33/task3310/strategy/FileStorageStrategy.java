package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private long maxBucketSize;
    //static final int DEFAULT_INITIAL_CAPACITY
    //static final long DEFAULT_BUCKET_SIZE_LIMIT
    //FileBucket[] table
    //int size
    //private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT
    //long maxBucketSize

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        for (FileBucket fb : table) {
            if (fb.getEntry().key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (table != null && table.length > 0) {
            for (FileBucket fb : table) {
                if (fb != null && fb.getEntry().value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        FileBucket bucket = new FileBucket();
        bucket.putEntry(new Entry(hash(key), key, value, null));
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                table[i] = bucket;
                break;
            } else if (i == table.length - 1 && table[i] != null) {
                resize(table.length + 1);
                break;
            }
        }
        table[table.length - 1] = bucket;
    }
    public int hash(Long key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public void resize(int newCapacity){
        FileBucket[] oldTab = table;
        table = new FileBucket[newCapacity];
        for (int i = 0; i < oldTab.length; i++) {
            table[i] = oldTab[i];
        }
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            if (fb.getEntry().value.equals(value)) {
                return fb.getEntry().key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        for (FileBucket fb : table) {
            if (fb.getEntry().key.equals(key)) {
                return fb.getEntry().value;
            }
        }
        return null;
    }
}
