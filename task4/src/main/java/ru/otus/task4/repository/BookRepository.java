package ru.otus.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Author;
import ru.otus.task4.domain.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

   long count();
   List<Book> findAll();

   void deleteById(Long id);

   Optional<Book> findById(Long id);

   Book save(Book book);


}
