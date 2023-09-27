package com.ua.foxminded.dmgolub.charcounter;

import java.util.function.Function;

public interface MapCache<K, V> {
    
    V lookup(K key, Function<K, V> mappingFunction);
    
    void invalidate();
}