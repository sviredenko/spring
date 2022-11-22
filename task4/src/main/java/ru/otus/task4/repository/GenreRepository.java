package ru.otus.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.otus.task4.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findAll();


    //@Query("Select l from Book s join Genre l on  where s.id = :id")

    Optional<Genre> findByGenre(String name);
}
