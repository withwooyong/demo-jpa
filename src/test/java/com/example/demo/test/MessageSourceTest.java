package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void getMessageTest() {
//        String code = "mission.notExist";
        String code = "site.title";
        var result = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        System.out.println(result);

    }
}
