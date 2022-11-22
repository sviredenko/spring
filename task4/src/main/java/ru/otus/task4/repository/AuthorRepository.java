package ru.otus.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.task4.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();

}
