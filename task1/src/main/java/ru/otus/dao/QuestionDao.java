package ru.otus.dao;

import ru.otus.domain.Question;

public class QuestionDao {
    Reader reader;
    private QuestionDao(Reader reader){
        this.reader = reader;
    }
    public Question[] getAllQuestion() { return reader.getAllQuestion();}
}
