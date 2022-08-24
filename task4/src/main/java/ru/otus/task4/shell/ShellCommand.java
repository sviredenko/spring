package ru.otus.task4.shell;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.task4.Task4Application;
import ru.otus.task4.domain.Question;
import ru.otus.task4.service.QuestionService;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {
    private String userName;
    final private QuestionService questionService;



    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }
    @ShellMethod(value = "asking", key = {"a"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void asking(){
        this.questionService.consoleLog();
    }
    @ShellMethod(value = "showTrueNumberAnswer", key = {"trueAnswer","t"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public String trueAnswer(){
        return  String.format("Number of right answer " +this.questionService.getRightAnswer());

    }
    @ShellMethod(value = "Get All Question and answer", key = {"qestion","q"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getQuestionAnswer(){
      this.questionService.consoleQuestionAnswer();

    }

    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("Сначала залогиньтесь"): Availability.available();
    }
}