package ru.javalab.simbirsofttask.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private final Counter counter = new Counter();


    @Test
    void countWords() {
        Map<String, Integer> counts = counter.countWords(new String[]{"word1", "word1", "word2", "word3", "word1"});
        assertEquals(3, counts.get("word1"));
        assertEquals(1, counts.get("word2"));
        assertNull(counts.get("abrakadabra"));

    }
}