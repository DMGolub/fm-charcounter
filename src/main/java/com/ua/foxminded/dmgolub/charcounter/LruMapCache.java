package com.ua.foxminded.dmgolub.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public final class LruMapCache<K, V> implements MapCache<K, V> {
    
    private Map<K, V> data;
    
    public LruMapCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Cache capacity can not be negative");
        }
        data = new LinkedHashMap<>(capacity) {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;
            private final int maxEntries = capacity;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxEntries;
            }
        };
    }
    
    @Override
    public V lookup(K key, Function<K, V> mappingFunction) {
        return data.computeIfAbsent(key, mappingFunction);
    }
    
    @Override
    public void invalidate() {
        data.clear();
    }
}