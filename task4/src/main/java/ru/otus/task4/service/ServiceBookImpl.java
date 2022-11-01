package ru.otus.task4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.BookDao;
import ru.otus.task4.domain.Author;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Comment;
import ru.otus.task4.domain.Genre;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceBookImpl implements ServiceBook{

   @Autowired
    BookDao dao;

   @Override
   public long getNumberOfBook(){
       long res = dao.count();
       System.out.println(res);
       return res;
   }
    @Override
    public void getAllBook(){
        List<Book> books = dao.findAll();
        for(int i = 0; i < books.size(); i++){
            System.out.print(books.get(i).getId() + "." + books.get(i).getBookName() );
            if(books.get(i).getAuthors().size() > 0)
                System.out.println(" By " + books.get(i).getAuthors().stream().map(x -> x.getAuthor()).collect(Collectors.joining(", ")));
            if(books.get(i).getGenres().size() > 0)
                System.out.println("  genres: " + books.get(i).getGenres().stream().map(x -> x.getGenre()).collect(Collectors.joining(", ")));
        }
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
       System.out.println("Delete by id:" + id);
       this.dao.deleteById(id);
    }

    @Override
    public void getBookById(Long Id){
        Optional<Book> book = this.dao.getBookById(Id);
        book.ifPresent(buf -> System.out.println(buf.getId() + "." + buf.getBookName()));

    }

    @Transactional
    @Override
    public void saveBook(){
        List<Author> authorNames = new ArrayList<Author>();
        List<Genre> genreNames = new ArrayList<Genre>();
        System.out.println("Enter your book");
        Scanner in = new Scanner(System.in);
        String bookName = in.nextLine();
        System.out.println("Enter authors if get end write 0");
        String authorName = in.nextLine();
        Author author = new Author();
        author.setId(0);
        author.setAuthor(authorName);
        authorNames.add(author);
        while(!authorName.equals("0")) {
            authorName = in.nextLine();
            author = new Author();
            author.setId(0);
            author.setAuthor(authorName);
            authorNames.add(author);
        }

        System.out.println("Enter genres if get end write 0");
        String genreName = in.nextLine();
        Genre genre = new Genre();
        genre.setId(0);
        genre.setGenre(genreName);
        genreNames.add(genre);
        while(!genreName.equals("0")) {
            genreName = in.nextLine();
            genre = new Genre();
            genre.setId(0);
            genre.setGenre(genreName);
            genreNames.add(genre);
        }
        Book book = new Book();
        book.setId(0);
        book.setBookName(bookName);
        book.setAuthors(authorNames);
        book.setComments(new ArrayList<Comment>());
        book.setGenres(genreNames);

        this.dao.save(book);

    }


}
