package ru.otus.task4.repository;

import ru.otus.task4.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    List<Genre> getAllGenre();
    List<Genre> getGenreByBookId(Long id);
    Optional<Genre> getGenreByName(String name);
}
