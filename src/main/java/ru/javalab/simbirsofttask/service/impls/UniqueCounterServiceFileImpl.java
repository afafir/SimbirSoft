package ru.javalab.simbirsofttask.service.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.service.interfaces.UniqueWordsCounterService;
import ru.javalab.simbirsofttask.utils.Counter;
import ru.javalab.simbirsofttask.utils.Splitter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service("file")
@Slf4j
public class UniqueCounterServiceFileImpl extends UniqueWordsCounterServiceImpl{

    @Autowired
    @Qualifier("default")
    UniqueWordsCounterServiceImpl uniqueWordsCounterService;


    private static final String DIRECTORY_PATH = "COUNTS\\";


    /**
     * This class is decorator over UniqueWordsCounterServiceImpl.
     * Now this method not only counts the number of words and outputs them to the console, but also saves them to a file
     * @param text - the text for which the number of words is calculated
     * @param link - the link to the page where the text is taken from
     * @return Returns the Map whose key is a word, and the value is the number of this word
     */
    @Override
    public Map<String, Integer> countAndSave(String text, String link) {
        Map<String, Integer> counts = uniqueWordsCounterService.countAndSave(text, link);
        File toSave = new File(DIRECTORY_PATH+UUID.randomUUID().toString()+".text");
        toSave.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(toSave)){
            writer.write("Counts for " + link + "\n");
            for (Map.Entry<String, Integer> entry : counts.entrySet()){
                writer.write(entry.getKey() +" count is "+entry.getValue()+"\n");
            }
        } catch (IOException e) {
            System.err.println("error path");
            log.error("Exception: "+e);
            System.exit(1);
        }
        System.out.println("Counts for "+link+ " saved into "+toSave.getAbsolutePath());
        return counts;
    }
}
