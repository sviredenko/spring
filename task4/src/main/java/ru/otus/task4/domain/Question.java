package ru.otus.task4.domain;

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
    public String getRightAnswer(){return rightAnswer;}
    public boolean checkQuestion(){
        return answer.equals(rightAnswer);
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public boolean equals(Object obj) {
        Question quest = (Question) obj;
        if (quest.getQuestion().equals(this.getQuestion())) {
            /*и верните */
            return true;
        }
        return false;
    }
}
