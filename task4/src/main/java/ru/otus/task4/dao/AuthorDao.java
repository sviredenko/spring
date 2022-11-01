package ru.otus.task4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.task4.domain.Author;

import java.util.List;

public interface AuthorDao extends JpaRepository<Author, Long> {
    List<Author> findAll();

}
