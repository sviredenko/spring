package ru.otus.task4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

   long count();
   List<Book> findAll();

   //void deleteById(Long id);

   Optional<Book> getBookById(Long id);

   Book save(Book book);

}
