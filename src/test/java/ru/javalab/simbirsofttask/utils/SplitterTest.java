package ru.javalab.simbirsofttask.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    private final Splitter splitter = new Splitter();

    @Test
    void splitWords() {
        String toTest = "this(string)for!test[this]string\nfor\ttest";
       String[] splitWords = splitter.splitWords(toTest);
       String[] expected= {"this", "string", "for", "test","this", "string", "for", "test"};
       assertArrayEquals(expected, splitWords);
    }
}