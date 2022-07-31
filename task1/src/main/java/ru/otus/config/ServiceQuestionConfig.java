package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.dao.QuestionDao;
import ru.otus.service.QuestionService;

@PropertySource("classpath:settings.properties")
@Configuration
public class ServiceQuestionConfig {
    @Bean
    public QuestionService serviceQuestion(QuestionDao questionDao){
        return new QuestionService(questionDao);
    }



}
