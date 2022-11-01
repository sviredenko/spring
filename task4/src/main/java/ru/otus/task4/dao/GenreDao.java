package ru.otus.task4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.otus.task4.domain.Genre;

import java.util.List;

public interface GenreDao extends JpaRepository<Genre, Long> {
    List<Genre>findAll();

    @Query("select b.genres from Book b where b.id = :id")
    List<Genre> getGenreByBookId(@Param("id") Long id);
}
