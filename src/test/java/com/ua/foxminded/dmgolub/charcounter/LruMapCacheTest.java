package com.ua.foxminded.dmgolub.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LruMapCacheTest {
    
    @SuppressWarnings("unchecked")
    private Function<String, Integer> mappingFunction = Mockito.mock(Function.class);
    
    @Test
    void cacheConstructor_shouldThrowIllegalAgrumentException_whenCapacityIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new LruMapCache<String, LinkedHashMap<Character, Integer>>(-2));
    }

    @Test
    void cache_shouldKeepSizeLessOrEqualToCapacity_whenNewItemsAdded() {        
        LruMapCache<String, Integer> smallCache = new LruMapCache<>(2);
        Mockito.when(mappingFunction.apply(Mockito.any())).thenReturn(1);
        
        smallCache.lookup("a", mappingFunction);
        smallCache.lookup("b", mappingFunction);
        smallCache.lookup("c", mappingFunction);
        smallCache.lookup("a", mappingFunction);
        
        Mockito.verify(mappingFunction, Mockito.times(2)).apply("a");
    }

    @Test
    void lookup_shouldReturnValueFromCache_whenCacheContainsInputStringAsAKey() {
        Mockito.when(mappingFunction.apply("a")).thenReturn(1);
        MapCache<String, Integer> cache = new LruMapCache<>(10);
        
        Integer result = cache.lookup("a", mappingFunction);
        
        Mockito.verify(mappingFunction).apply("a");
        assertEquals(1, result);
    }

    @Test
    void lookup_shouldComputeAndPutValueInTheCache_whenCacheDoesNotContainInputStringAsAKey() {
        LruMapCache<String, Integer> cache = new LruMapCache<>(10);
        
        cache.lookup("abc", mappingFunction);
        
        Mockito.verify(mappingFunction).apply("abc");
    }
}