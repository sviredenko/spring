package ru.otus.task4.shell;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import ru.otus.task4.service.*;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {
    private String userName;


    private final ServiceBook service;
    private final ServiceAuthor serviceAuthor;
    private final ServiceComment serviceComment;

    private final ServiceGenre serviceGenre;


    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String userName) {
        this.userName = userName;
        return String.format("Добро пожаловать: %s", userName);
    }
    @ShellMethod(value = "Number of  book in archive", key = {"Number of books in archive","t"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void CountBooks(){
        service.getNumberOfBook();
        return;
    }
    @ShellMethod(value = "Insert comment in book by id", key = {"icb"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void insertCommentById(){
        serviceComment.putCommentById();
        return;
    }
    @ShellMethod(value = "Get All books", key = {"gbs"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllBook(){
      this.service.getAllBook();

    }

    @ShellMethod(value = "Get All authors", key = {"gaa"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllAuthors(){
        this.serviceAuthor.getAllAuthor();
    }
    @ShellMethod(value = "Get comments by book's id", key = {"gca"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllCommnetsById(){
        this.serviceComment.getAllCommnetsById();
    }
    /*
    @ShellMethod(value = "Get All genres", key = {"gag"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllGenres(){
        this.service.getAllGenre();
    }*/

    @ShellMethod(value = "insert book", key = {"ib"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  insertBook(){
        this.service.saveBook();

    }

    @ShellMethod(value = "get book by id", key = {"gbi"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getBookById(Long id){
        this.service.getBookById(id);

    }
    @ShellMethod(value = "delete  book by id", key = {"dbi"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  deleteBookById(@ShellOption(defaultValue = "None") Long id){
        this.service.deleteBookById(id);

    }
    @ShellMethod(value = "getAllGenre", key = {"gag"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getAllGenre(){
        this.serviceGenre.getAllGenre();
    }

    @ShellMethod(value = "get genre by id book", key = {"ggi"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void  getGenreById(@ShellOption(defaultValue = "None") Long id){
        this.serviceGenre.getGenreByBookId(id);
    }

   /* @ShellMethod(value = "update nameBook", key = {"un"})
    @ShellMethodAvailability(value = "isPublishEventCommandAvailable")
    public void updateBookById(){
        this.service.updateBookById();
    }
*/
    private Availability isPublishEventCommandAvailable() {
        return userName == null? Availability.unavailable("Сначала залогиньтесь"): Availability.available();
    }
}
