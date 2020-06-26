package ru.javalab.simbirsofttask.utils;

import org.springframework.stereotype.Component;

@Component
public class Splitter {
    private static final String DELIMITER = "[ ,.!?\'\";:()\n\r\t\\[\\]]";

    public String[] splitWords(String string){
        return string.split(DELIMITER);
    }
}
