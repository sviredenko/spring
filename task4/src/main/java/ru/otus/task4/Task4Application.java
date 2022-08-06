package ru.otus.task4;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.task4.service.QuestionService;

@SpringBootApplication
public class Task4Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Task4Application.class);
		QuestionService console  = context.getBean(QuestionService.class);
		console.consoleLog();
	}

}
