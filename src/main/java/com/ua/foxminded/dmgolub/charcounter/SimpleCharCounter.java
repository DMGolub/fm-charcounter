package com.ua.foxminded.dmgolub.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public final class SimpleCharCounter implements CharCounter {
    
    @Override
    public Map<Character, Integer> count(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); ++i) {
            result.merge(input.charAt(i), 1, (ov, nv) -> ov + nv);
        }
        return result;
    }
}