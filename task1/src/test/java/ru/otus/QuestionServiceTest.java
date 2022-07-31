package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;
import ru.otus.service.QuestionService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@DisplayName("Класс сервис")
@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    private Question[]  questions;
   @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setUp(){
        questions = new Question[2];
        questions[0] = new  Question("question1","answer1");
        questions[1] = new  Question("question2","answer2");
    }

    @Test
    void checkConsoleLog(){
        given(questionDao.getAllQuestion())
                .willReturn(questions);

        assertThat(questionService.getAllQuestions())
                .isNotNull()
                .contains(new Question("question1","answer1"));

    }

}
