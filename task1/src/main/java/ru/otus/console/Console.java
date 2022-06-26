package ru.otus.console;

import ru.otus.domain.Question;

import java.util.Scanner;

public class Console {
    Question question;
    String[] ans;
    public Console(Question question){
        this.question = question;
        ans = new String[5];
    }
    public void consoleLog(){
        Scanner in = new Scanner(System.in);
        System.out.println(question.getAnswer(0));
        ans[0] = in.next();
        System.out.println(question.getAnswer(1));
        ans[1] = in.next();
        System.out.println(question.getAnswer(2));
        ans[2] = in.next();
        System.out.println(question.getAnswer(3));
        ans[3] = in.next();
        System.out.println(question.getAnswer(4));
        ans[4] = in.next();
    }
}
