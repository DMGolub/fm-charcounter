package com.ua.foxminded.dmgolub.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SimpleCharCounterTest {
    
    private CharCounter charCounter = new SimpleCharCounter();
    
    @Test
    void count_shouldThrowIllegalAgrumentException_whenInputStringIsNull() {
        String input = null;
        
        assertThrows(IllegalArgumentException.class, () -> charCounter.count(input));
    }

    @Test
    void count_shouldReturnEmptyResult_whenInputStringIsEmpty() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        
        assertEquals(expected, charCounter.count(""));
    }

    @Test
    void count_shouldReturnOneCharacter_whenInputContainsOneCharacter() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        
        assertEquals(expected, charCounter.count("a"));
    }

    @Test
    void count_shouldCountEqualCharacters_whenInputContainsEqualCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 5);
        
        assertEquals(expected, charCounter.count("aaaaa"));
    }
    
    @Test
    void count_shouldReturnResultFromTheTask_whenComplexCountIsPerformed() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);
        
        assertEquals(expected, charCounter.count("hello world!"));
    }
}