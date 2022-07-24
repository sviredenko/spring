package ru.otus;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.service.ServiceQuestion;

@ComponentScan(basePackages = "ru.otus")
@Configuration
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ServiceQuestion console  = context.getBean(ServiceQuestion.class);
        console.consoleLog();
    }
}
