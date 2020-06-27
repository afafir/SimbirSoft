package ru.javalab.simbirsofttask.service.impls;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javalab.simbirsofttask.repository.WordCountRepositoryJpa;
import ru.javalab.simbirsofttask.utils.Counter;
import ru.javalab.simbirsofttask.utils.Splitter;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UniqueCounterServiceWithDbImplTest {

    @Mock
    private UniqueWordsCounterServiceImpl uniqueWordsCounterService;
    @Mock
    private WordCountRepositoryJpa wordCountRepositoryJpa;
    @InjectMocks
    private UniqueCounterServiceWithDbImpl uniqueWordsCounterServiceWithDb;

    @Test
    void countAndSave() {
        Mockito.doReturn(new LinkedHashMap<String, Integer>() {{
            put("word1", 1);
            put("word2", 1);
        }}).when(uniqueWordsCounterService).countAndSave("word1 word2","link");
        Map<String, Integer>  words  = uniqueWordsCounterServiceWithDb.countAndSave("word1 word2", "link");

        assertEquals(words.get("word1"), 1);
        assertEquals(words.size(), 2);
        assertNull(words.get("xd"));

    }
}