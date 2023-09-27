package com.ua.foxminded.dmgolub.charcounter;

import java.util.Map;

public class CachedCharCounter extends CharCounterDecorator {
    
    private MapCache<String, Map<Character, Integer>> cache;

    public CachedCharCounter(CharCounter charCounter, int cacheCapacity) {
        super(charCounter);
        if (cacheCapacity < 0) {
            throw new IllegalArgumentException("Cache capacity can not be negative");
        }
        this.cache = new LruMapCache<>(cacheCapacity);
    }

    @Override
    public Map<Character, Integer> count(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        return cache.lookup(input, super::count);
    }
}