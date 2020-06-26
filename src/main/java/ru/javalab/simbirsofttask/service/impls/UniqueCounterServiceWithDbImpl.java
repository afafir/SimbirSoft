package ru.javalab.simbirsofttask.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.model.WordCount;
import ru.javalab.simbirsofttask.repository.WordCountRepositoryJpa;
import java.util.Map;

@Service("db")
public class UniqueCounterServiceWithDbImpl extends UniqueWordsCounterServiceImpl {


    @Autowired
    @Qualifier("default")
    UniqueWordsCounterServiceImpl uniqueWordsCounterService;

    @Autowired
    private WordCountRepositoryJpa wordCountRepositoryJpa;

    /**
     * This class is decorator over UniqueWordsCounterServiceImpl.
     * Now this method not only counts the number of words and outputs them to the console, but also saves them to a database
     * @param text - the text for which the number of words is calculated
     * @param link - the link to the page where the text is taken from
     * @return Returns the Map whose key is a word, and the value is the number of this word
     */
    @Override
    public Map<String, Integer> countAndSave(String text, String link) {
        Map<String, Integer> counts = uniqueWordsCounterService.countAndSave(text, link);
        for (Map.Entry<String, Integer> entry : counts.entrySet()){
            WordCount wordCount = WordCount.builder()
                    .count(entry.getValue())
                    .word(entry.getKey())
                    .link(link)
                    .build();
            wordCountRepositoryJpa.save(wordCount);
        }
        return counts;
    }
}
