package com.ua.foxminded.dmgolub.charcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        CharCounterDecorator charCounter = new CachedCharCounter(new SimpleCharCounter(), 100);
        CounterResultFormatter formatter = new CounterResultFormatter();

        System.out.println("Type a sentense to count characters. Type 'exit' to quit.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String input = reader.readLine();
        while (!input.equals("exit")) {
            Map<Character, Integer> calculationResult = charCounter.count(input);
            System.out.println(formatter.format(calculationResult));
            input = reader.readLine();
        }
    }
}