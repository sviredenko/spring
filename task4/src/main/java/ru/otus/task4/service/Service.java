package ru.otus.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.task4.dao.Dao;
import ru.otus.task4.dao.DaoJdbc;
import ru.otus.task4.domain.Book;
import java.util.List;
import java.util.Scanner;


@org.springframework.stereotype.Service
public class Service {
    final private Dao dao;

    @Autowired
    public Service(DaoJdbc dao){
        this.dao = dao;
    }
    public void getAllBook(){
        List<Book> books = dao.getAllBooks();
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).getId() + "." + books.get(i).getBookName());
        }
    }
  /*  public void insertBook(Long id, String bookName,Long keyAuthor, Long keyGender){
        Book book = new Book(id, bookName,keyAuthor, keyGender);
        this.dao.insertBook(book);
        return;
    }*/
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
    public void numberOfBook(){
        System.out.println("Number of books:" + dao.count());
    }
    public void getBookById(Long id){
      Book book = this.dao.getBookById(id);;
        System.out.println(book.getId() + "." + book.getBookName());
    }
    public void deleteBookById(Long id){
      this.dao.deleteBookById(id);
    }
}
