package ru.otus;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.ServiceQuestion;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./spring-context.xml");
        ServiceQuestion console  = context.getBean(ServiceQuestion.class);
        console.consoleLog();
    }
}
