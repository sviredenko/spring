package ru.otus;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.console.Console;
import ru.otus.domain.Question;
import ru.otus.reader.Reader;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./spring-context.xml");
        Console console  = context.getBean(Console.class);
        console.consoleLog();
    }
}
