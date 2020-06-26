package ru.javalab.simbirsofttask.service.interfaces;

import java.io.File;
import java.util.Map;

public interface UniqueWordsCounterService {


    Map<String, Integer> countAndSave(String text, String link);

}
