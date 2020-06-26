package ru.javalab.simbirsofttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.service.interfaces.ParserService;
import ru.javalab.simbirsofttask.service.interfaces.SaverService;
import ru.javalab.simbirsofttask.service.interfaces.UniqueWordsCounterService;

import java.util.Map;

@Service
public class Solve {


    @Autowired
    ParserService parserService;
    @Autowired
    private Map<String, UniqueWordsCounterService> uniqueWordsCounterServiceMap;
    @Autowired
    SaverService saverService;



    public void solve(String link, String realization){
        String filename = saverService.save(link);
        String text = parserService.parseHtml(filename);
        uniqueWordsCounterServiceMap.get(realization).countAndSave(text, link);
    }



}
