package com.ua.foxminded.dmgolub.charcounter;

import java.util.Map.Entry;
import java.util.Map;
import java.util.StringJoiner;

public final class CounterResultFormatter implements Formatter<Map<Character, Integer>> {
    
    public CounterResultFormatter() {}
    
    @Override
    public String format(Map<Character, Integer> calculationResult) {
        if (calculationResult == null) {
            throw new IllegalArgumentException("Input must not be null!");
        }
        StringJoiner result = new StringJoiner(System.lineSeparator());
        for (Entry<Character, Integer> item : calculationResult.entrySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append("\"")
            .append(item.getKey())
            .append("\"")
            .append(" - ")
            .append(item.getValue());
            result.add(builder.toString());
        }
        return result.toString();
    }
}