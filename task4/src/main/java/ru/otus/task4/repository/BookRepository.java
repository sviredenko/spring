package ru.otus.task4.repository;

import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {

   long count();
   List<Book> getAllBooks();

   void deleteBookById(Long id);

   Optional<Book> getBookById(Long id);

   Book saveBook(Book book);


}
