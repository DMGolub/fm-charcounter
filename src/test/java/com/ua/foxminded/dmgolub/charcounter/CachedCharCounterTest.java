package com.ua.foxminded.dmgolub.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CachedCharCounterTest {
    
    private CharCounter charCounterMock = Mockito.mock(CharCounter.class);
    private CharCounterDecorator cachedCharCounter = new CachedCharCounter(charCounterMock, 100);

    @Test
    void counterConstructor_shouldThrowIllegalAgrumentException_whenCapacityIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new CachedCharCounter(charCounterMock, -3));
    }
    
    @Test
    void cachedCharCounter_shouldThrowIllegalAgrumentException_whenInputStringIsNull() {
        String input = null;
        
        assertThrows(IllegalArgumentException.class, () -> cachedCharCounter.count(input));
    }
    
    @Test
    void cachedCharCounter_shouldCallWrappeeCountOnlyOnce_whenTwoIdenticalValuesAreTaken() {
        cachedCharCounter.count("a");
        cachedCharCounter.count("a");
        
        Mockito.verify(charCounterMock).count("a");
    }
    
    @Test
    void cachedCharCounter_shouldNotChangeWrapeeReturnValue_whenDecorating() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        Mockito.when(charCounterMock.count("a")).thenReturn(expected);
        
        Map<Character, Integer> result = cachedCharCounter.count("a");
        
        assertSame(expected, result);
    }
}
