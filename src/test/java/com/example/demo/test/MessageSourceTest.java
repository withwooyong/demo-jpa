package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }


    @Test
    void getMessageTest() {
        String code = "mission.notExist";
        var result = messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        System.out.println(result);

    }
}
