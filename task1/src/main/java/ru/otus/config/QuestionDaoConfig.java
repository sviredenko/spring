package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.dao.QuestionDao;
import ru.otus.dao.Reader;

@Configuration
public class QuestionDaoConfig {
    @Bean
    public QuestionDao questionDao(Reader reader){
        return new QuestionDao(reader);
    }

}
