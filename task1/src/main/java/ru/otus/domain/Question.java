package ru.otus.domain;

import ru.otus.reader.Reader;

public class Question {
    Reader reader;
    public Question(Reader reader){
        this.reader = reader;
    }
    public  String getAnswer(int i){
        return reader.getList()[i];
    }
}
