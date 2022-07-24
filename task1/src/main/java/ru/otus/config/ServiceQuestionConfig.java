package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.dao.QuestionDao;
import ru.otus.service.ServiceQuestion;

@PropertySource("classpath:settings.properties")
@Configuration
public class ServiceQuestionConfig {
    @Bean
    public ServiceQuestion serviceQuestion(QuestionDao questionDao){
        return new ServiceQuestion(questionDao);
    }



}
