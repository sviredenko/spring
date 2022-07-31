package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.otus.dao.QuestionDao;
import ru.otus.domain.Question;

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
