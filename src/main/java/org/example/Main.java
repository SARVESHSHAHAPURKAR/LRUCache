package org.example;

public class Main {
    public static void main(String[] args) {

        LRUCache<Integer, String>  lruCache = new LRUCache<>(3);

        lruCache.put(1,"One");
        lruCache.put(2,"Teo");
        lruCache.put(3,"Three");

        System.out.println("2 is "+lruCache.getValue(2));
        lruCache.put(4,"Four");

        System.out.println("1 is "+lruCache.getValue(1));
    }
}