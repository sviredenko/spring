package ru.otus;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.Console;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./spring-context.xml");
        Console console  = context.getBean(Console.class);
        console.consoleLog();
    }
}
