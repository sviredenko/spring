package ru.otus.domain;

import ru.otus.dao.Reader;

public class Question {
    private String answer;
    private final  String rightAnswer;
    private final String question;
    public Question(String question, String answer){
        this.rightAnswer = answer;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
    public boolean checkQuestion(){
        return answer.equals(rightAnswer);
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
