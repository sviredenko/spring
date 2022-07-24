package ru.otus.service;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.domain.Question;
import java.util.Scanner;
import ru.otus.dao.QuestionDao;
public class ServiceQuestion {
    private final QuestionDao dao;

    public ServiceQuestion(QuestionDao dao){
        this.dao = dao;
    }
    public Question[] getAllQuestions(){
        return this.dao.getAllQuestion();
    }

    @Value("${pass_exam}")
    private int pass_exam;
    public void consoleLog(){
        Question[] questions;
        questions = this.getAllQuestions();
        Scanner in = new Scanner(System.in);
        int countTrueAnswer = 0;
        for(int i = 0; i < 5; i++) {
            System.out.println(questions[i].getQuestion());
            questions[i].setAnswer(in.next());
            if(questions[i].checkQuestion()){
                System.out.println("Correct Answer");
                countTrueAnswer++;
            }
            else{
                System.out.println("Incorrect Answer");
            }
        }
        System.out.println("Your result is:" + Integer.toString(countTrueAnswer) + "/" + Integer.toString(5));
        if(pass_exam <= countTrueAnswer){
            System.out.println("You passed  exam");
        }
        else{
            System.out.println("You failed exam");
        }

    }
}
