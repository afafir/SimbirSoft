package ru.javalab.simbirsofttask.service.impls;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javalab.simbirsofttask.service.interfaces.UniqueWordsCounterService;
import ru.javalab.simbirsofttask.utils.Counter;
import ru.javalab.simbirsofttask.utils.Splitter;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UniqueWordsCounterServiceImplTest {
    @Mock
    private Counter counter;
    @Mock
    private Splitter splitter;
    @InjectMocks
    private UniqueWordsCounterServiceImpl uniqueWordsCounterService;


    @Test
    void countAndSave() {
        Mockito.doReturn(new String[]{"word1", "word2"}).when(splitter).splitWords("word1 word2");
        Mockito.doReturn(new LinkedHashMap<String, Integer>() {{
            put("word1", 1);
            put("word2", 1);
        }}).when(counter).countWords(new String[]{"word1", "word2"});
        Map<String, Integer> map = uniqueWordsCounterService.countAndSave("word1 word2", "link");
        assertEquals(1, map.get("word1"));
        assertEquals(2, map.size());
        assertEquals(0, map.get("xd"));
            }
}