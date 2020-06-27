package ru.javalab.simbirsofttask.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;
import ru.javalab.simbirsofttask.model.WordCount;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class WordCountRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WordCountRepositoryJpa wordCountRepositoryJpa;

    private List<WordCount> wordCounts;

    @BeforeEach
    public void initialize(){
        WordCount wordCount = WordCount.builder()
                .link("www.sss.ru")
                .word("word1")
                .count(3)
                .build();
        WordCount wordCount1 = WordCount.builder()
                .link("www.sss.ru")
                .word("word2")
                .count(3)
                .build();
        WordCount wordCount2 = WordCount.builder()
                .link("www.sss.ru")
                .word("word3")
                .count(4)
                .build();
        wordCounts = Arrays.asList(wordCount, wordCount1, wordCount2);
    }

    @Test
    public void whenFindAll_thenReturnList(){

        for (WordCount wordCount: wordCounts) {
            entityManager.persist(wordCount);
        }
        entityManager.flush();
        List<WordCount> wordCounts = wordCountRepositoryJpa.findAll();
        Assert.notEmpty(wordCounts,String.valueOf(wordCounts.size()));
        assertEquals(3, wordCounts.size());


    }

}