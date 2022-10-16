package ru.otus.task4.shell;


import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.task4.service.Service;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {
    private String userName;
    final private Service service;



    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }
    @ShellMethod(value = "Number of  book in archive", key = {"Number of books in archive","t"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void CountBooks(){
        service.numberOfBook();
        return;
    }
    @ShellMethod(value = "Get All books", key = {"gbs"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllBook(){
      this.service.getAllBook();

    }
    @ShellMethod(value = "insert book", key = {"ib"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  insertBook(){
        this.service.insertBook();

    }

    @ShellMethod(value = "get book by id", key = {"gbi"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getBookById(Long id){
        this.service.getBookById(id);

    }
    @ShellMethod(value = "delete  book by id", key = {"dbi"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  deleteBookById(Long id){
        this.service.deleteBookById(id);

    }

    @ShellMethod(value = "update nameBook", key = {"un"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void updateBookById(){
        this.service.updateBookById();
    }


    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("Сначала залогиньтесь"): Availability.available();
    }
}
