package com.ua.foxminded.dmgolub.charcounter;

import java.util.Map;

public interface CharCounter {

    Map<Character, Integer> count(String input);
}