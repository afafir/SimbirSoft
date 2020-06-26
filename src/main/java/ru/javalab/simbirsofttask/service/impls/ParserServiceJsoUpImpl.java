package ru.javalab.simbirsofttask.service.impls;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.service.interfaces.ParserService;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j

public class ParserServiceJsoUpImpl implements ParserService {


    /**
     * Gets html file from disk and parses it to String. Catches IO exception if path to the file is wrong   (ex. link to not-HTML file)
     *
     *
     * @param filePath - path to the HTML we want to parsse
     * @return returns parsed text from HTML
     */
    @Override
    public String parseHtml(String filePath) {
        try {
            Document document = Jsoup.parse(new File(filePath), "UTF-8");
            return document.body().text();
        } catch (IOException e) {
            log.error("Exception: "+e);
            System.err.println("File not found");
            System.exit(1);
        }
        return null;
    }

}
