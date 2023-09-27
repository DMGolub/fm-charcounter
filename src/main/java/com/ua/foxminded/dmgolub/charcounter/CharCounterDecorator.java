package com.ua.foxminded.dmgolub.charcounter;

import java.util.Map;

public abstract class CharCounterDecorator implements CharCounter {

    private CharCounter wrappee;
    
    public CharCounterDecorator(CharCounter charCounter) {
        this.wrappee = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String input) {
        return wrappee.count(input);
    }
}