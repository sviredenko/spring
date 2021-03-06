package ru.otus.service;
import ru.otus.domain.Question;
import java.util.Scanner;
import ru.otus.dao.QuestionDao;
public class ServiceQuestion {
    final private QuestionDao dao;
    final private Question[] questions;
    public ServiceQuestion(QuestionDao dao){
        this.dao = dao;
        questions = dao.getAllQuestion();
    }
    public void consoleLog(){
        Scanner in = new Scanner(System.in);
        int j = 0;
        for(int i = 0; i < 5; i++) {
            System.out.println(questions[i].getQuestion());
            questions[i].setAnswer(in.next());
            if(questions[i].checkQuestion()){
                System.out.println("Correct Answer");
                j++;
            }
            else{
                System.out.println("Incorrect Answer");
            }
        }
        System.out.println("Your result is:" + Integer.toString(j) + "/" + Integer.toString(5));

    }
}
