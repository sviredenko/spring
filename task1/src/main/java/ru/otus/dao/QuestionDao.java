package ru.otus.dao;

import ru.otus.domain.Question;

public class QuestionDao {
    private final  Reader reader;
    public QuestionDao(Reader reader){
        this.reader = reader;
    }
    public Question[] getAllQuestion() { return this.reader.getAllQuestion();}
}
