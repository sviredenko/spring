package ru.otus.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.QuestionDao;
import ru.otus.task4.domain.Question;

import java.util.List;
import java.util.Scanner;

@Service
@PropertySource("classpath:settings.properties")
public class QuestionService {
    private final QuestionDao dao;

    @Autowired
    public QuestionService(QuestionDao dao){
        this.dao = dao;
    }
    public List<Question> getAllQuestions(){
        return this.dao.getAllQuestion();
    }

    @Value("${pass_exam}")
    private int pass_exam;
    private int rightAnswer;

    public int getRightAnswer() {
        return rightAnswer;
    }
    public void consoleQuestionAnswer(){
        List<Question> questions = this.getAllQuestions();
        System.out.println("All questions and answer");
        for(int i = 0; i < questions.size(); i++){
            System.out.println(questions.get(i).getQuestion());
            System.out.println(questions.get(i).getRightAnswer());
        }
    }
    public void consoleLog(){
        List<Question> questions;
        questions = this.getAllQuestions();
        Scanner in = new Scanner(System.in);
        int countTrueAnswer = 0;
        for(int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i).getQuestion());
            questions.get(i).setAnswer(in.next());
            if(questions.get(i).checkQuestion()){
                System.out.println("Correct Answer");
                countTrueAnswer++;
            }
            else{
                System.out.println("Incorrect Answer");
            }
        }
        System.out.println("Your result is:" + Integer.toString(countTrueAnswer) + "/" + Integer.toString(5));
        this.rightAnswer = countTrueAnswer;
        if(pass_exam <= countTrueAnswer){
            System.out.println("You passed  exam");
        }
        else{
            System.out.println("You failed exam");
        }

    }
}
