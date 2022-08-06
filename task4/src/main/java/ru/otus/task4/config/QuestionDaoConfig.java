package ru.otus.task4.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.task4.dao.QuestionDao;

@Configuration
public class QuestionDaoConfig {
    @Bean
    public QuestionDao questionDao(@Value("${filename}") String str){
        return new QuestionDao(str);
    }

}
