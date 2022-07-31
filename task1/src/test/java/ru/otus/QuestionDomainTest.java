package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.domain.Question;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionDomainTest {
    private Question question;

    @BeforeEach
    void setUp(){
        this.question = new Question("How are you?","Fine");
    }

    @DisplayName("Тест на конструктор")
    @Test
    void checkConstructor(){
        assertThat(this.question)
                .hasFieldOrPropertyWithValue("question","How are you?")
                .hasFieldOrPropertyWithValue("rightAnswer", "Fine");
    }

    @DisplayName("Проверка получения поля")
    @Test
    void checkQuestiong(){
        assertEquals(this.question.getQuestion(), "How are you?");
    }
}
