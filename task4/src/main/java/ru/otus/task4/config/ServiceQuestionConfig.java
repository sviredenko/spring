package ru.otus.task4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.task4.dao.QuestionDao;
import ru.otus.task4.service.QuestionService;


@PropertySource("classpath:settings.properties")
@Configuration
public class ServiceQuestionConfig {
    @Bean
    public QuestionService serviceQuestion(QuestionDao questionDao){
        return new QuestionService(questionDao);
    }



}
