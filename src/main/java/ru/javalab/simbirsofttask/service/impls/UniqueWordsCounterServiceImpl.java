package ru.javalab.simbirsofttask.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.service.interfaces.UniqueWordsCounterService;
import ru.javalab.simbirsofttask.utils.Counter;
import ru.javalab.simbirsofttask.utils.Splitter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;
@Service("default")
public class UniqueWordsCounterServiceImpl implements UniqueWordsCounterService {

    @Autowired
    private Counter counter;
    @Autowired
    private Splitter splitter;


    /**
     *  This method counts the number of words and outputs them to the console
     * @param text - the text for which the number of words is calculated
     * @param link - the link to the page where the text is taken from
     * @return Returns the Map whose key is a word, and the value is the number of this word
     */
    @Override
    public Map<String, Integer> countAndSave(String text, String link) {
        String[] words = splitter.splitWords(text);
        Map<String, Integer> counts = counter.countWords(words);
        for (Map.Entry<String, Integer>  entry : counts.entrySet()){
            System.out.println(entry.getKey() +" counts is " + entry.getValue());
        }
        return counts;
    }
}
