package ru.otus.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.otus.task4.dao.QuestionDao;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionDaoTest {

    private QuestionDao questionDao;

    @BeforeEach
    void setUp(){
        questionDao = new QuestionDao("./Q.csv");
    }

    @DisplayName("Dao проверка кол-во вопросов возвращает")
    @Test
    void  checkNumberOfQuestions(){
      assertThat(questionDao.getAllQuestion().length).isEqualTo(5);
    }

}
