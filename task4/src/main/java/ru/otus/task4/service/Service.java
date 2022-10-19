package ru.otus.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.task4.dao.Dao;
import ru.otus.task4.dao.DaoJdbc;
import ru.otus.task4.domain.Author;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Genre;

import java.util.List;
import java.util.Scanner;


@org.springframework.stereotype.Service
public class Service implements ServiceImp{
    final private Dao dao;

    @Autowired
    public Service(DaoJdbc dao){
        this.dao = dao;
    }
    @Override
    public void getAllBook(){
        List<Book> books = dao.getAllBooks();
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).getId() + "." + books.get(i).getBookName());
        }
    }

    @Override
    public void getAllAuthor(){
        List<Author> authors = dao.getAllAuthors();
        for(int i = 0; i < authors.size(); i++){
            System.out.println(authors.get(i).getId() + "." + authors.get(i).getName());
        }
    }

    @Override
    public void getAllGenre(){
        List<Genre> genres = dao.getAllGenres();
        for(int i = 0; i < genres.size(); i++){
            System.out.println(genres.get(i).getId() + "." + genres.get(i).getGenre());
        }
    }

    @Override
  public void insertBook() {
      Scanner console = new Scanner(System.in);

      System.out.println("Enter id");
      long id = Long.parseLong(console.nextLine());
      System.out.println("Enter bookName");
      String bookName  = console.nextLine();
      System.out.println("Enter keyAuthor");
      long keyAuthor = Long.parseLong(console.nextLine());
      System.out.println("Enter keyGender");
      long keyGender = Long.parseLong(console.nextLine());
      Book book = new Book(id, bookName, keyAuthor, keyGender);
      this.dao.insertBook(book);
      return;
  }
  @Override
    public void numberOfBook(){
        System.out.println("Number of books:" + dao.count());
    }
    @Override
    public void getBookById(Long id){
      Book book = this.dao.getBookById(id);;
        System.out.println(book.getId() + "." + book.getBookName());
    }

    @Override
    public void updateBookById(){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter id");
        long id = Long.parseLong(console.nextLine());
        System.out.println("Enter bookName");
        String bookName  = console.nextLine();
        System.out.println("Enter keyAuthor");
        long keyAuthor = Long.parseLong(console.nextLine());
        System.out.println("Enter keyGender");
        long keyGender = Long.parseLong(console.nextLine());
        Book book = new Book(id, bookName, keyAuthor, keyGender);
        this.dao.update(book);
    }
    @Override
    public void deleteBookById(Long id){
      this.dao.deleteBookById(id);
    }
}
