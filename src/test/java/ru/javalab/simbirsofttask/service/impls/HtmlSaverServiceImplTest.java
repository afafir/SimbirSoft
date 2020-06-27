package ru.javalab.simbirsofttask.service.impls;


import com.ginsberg.junit.exit.ExpectSystemExit;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)

class HtmlSaverServiceImplTest {

    private HtmlSaverServiceImpl htmlSaverService = new HtmlSaverServiceImpl();

    @Test
    @ExpectSystemExit
    void saveWithWrongUrl() {
        htmlSaverService.save("wronglink");
    }
    @Test
    @ExpectSystemExit
    void saveWith404Code() {
        htmlSaverService.save("https://www.simbirsoft.com/whereispage/");
    }

    @Test
    void save(){
       String path =  htmlSaverService.save("https://www.simbirsoft.com");
        Assert.assertNotNull(path);
        Assertions.assertThat(path.contains(".html"));
    }
}