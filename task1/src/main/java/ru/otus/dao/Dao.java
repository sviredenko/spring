package ru.otus.dao;

import ru.otus.dao.Reader;
import ru.otus.domain.Question;

public class Dao {
    Reader reader;
    private Dao(Reader reader){
        this.reader = reader;
    }
    public Question[] getAllQuestion() { return reader.getAllQuestion();}
}
