package ru.otus.task4.dao;

import ru.otus.task4.domain.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAllGenre();
    List<Genre> getGenreByBookId(Long id);
}
