package ru.otus.task4.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDao  {

   long count();
   List<Book> getAllBooks();

   void deleteBookById(Long id);

   Optional<Book> getBookById(Long id);

   Book saveBook(Book book);


}
