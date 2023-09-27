package com.ua.foxminded.dmgolub.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.junit.jupiter.api.Test;

class CounterResultFormatterTest {
    private CounterResultFormatter formatter = new CounterResultFormatter();
    
    @Test
    void formatter_shouldThrowIllegalArgumentException_whenInputIsNull() {        
        assertThrows(IllegalArgumentException.class, () -> formatter.format(null));
    }

    @Test
    void formatter_shouldReturnEmptyString_whenCounterResultIsEmpty() {      
        Map<Character, Integer> counterResult = new LinkedHashMap<>();
        
        assertEquals("", formatter.format(counterResult));
    }
    
    @Test
    void formatter_shouldReturnOneLine_whenCounterResultContainsOneCharacter() {
        String expected = new String("\"a\" - 1");
        
        Map<Character, Integer> counterResult = new LinkedHashMap<>();
        counterResult.put('a', 1);

        assertEquals(expected, formatter.format(counterResult));
    }
    
    @Test
    void formatter_shouldReturnMultilineString_whenResultContainsSeveralCharacters() {
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add("\"h\" - 1")
                .add("\"e\" - 1")
                .add("\"l\" - 3")
                .add("\"o\" - 2")
                .add("\" \" - 1")
                .add("\"w\" - 1")
                .add("\"r\" - 1")
                .add("\"d\" - 1")
                .add("\"!\" - 1")
                .toString();
        
        Map<Character, Integer> counterResult = new LinkedHashMap<>();
        counterResult.put('h', 1);
        counterResult.put('e', 1);
        counterResult.put('l', 3);
        counterResult.put('o', 2);
        counterResult.put(' ', 1);
        counterResult.put('w', 1);
        counterResult.put('r', 1);
        counterResult.put('d', 1);
        counterResult.put('!', 1);

        assertEquals(expected.toString(), formatter.format(counterResult));
    }
}
