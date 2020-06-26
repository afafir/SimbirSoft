package ru.javalab.simbirsofttask.service.impls;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ru.javalab.simbirsofttask.service.interfaces.SaverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Service
@Slf4j
public class HtmlSaverServiceImpl implements SaverService {

    private static final String DIRECTORY_PATH = "PAGES\\";

    /**
     * Saves the HTML page to the folder of DIRECTORY_PATH.
     * Catches MalformedUrl if link is wrong and IO exception if some troubles with downloading of page(ex. 404 error at the page)
     * @param link - its link the link to the web page you want to save on the disk
     * @return returns path of the saved file
      */

    @Override
    public String save(Object link) {
        File dstFile = new File(DIRECTORY_PATH+ UUID.randomUUID().toString()+".html");
        try {
            URL url = new URL((String) link);
            FileUtils.copyURLToFile(url, dstFile);
        } catch (MalformedURLException e) {
            log.error("Exception: "+e);
            System.err.println("Wrong url");
            System.exit(1);
        } catch (IOException e) {
            log.error("Exception: "+e);
            System.err.println("Some error occurred, check correctness of link");
            System.exit(1);
        }
        System.out.println("Html saved. File path: "+dstFile.getAbsolutePath());
        return dstFile.getPath();
    }
}
