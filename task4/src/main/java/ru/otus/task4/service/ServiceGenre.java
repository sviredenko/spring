package ru.otus.task4.service;

import ru.otus.task4.domain.Genre;

import java.util.Optional;

public interface ServiceGenre {
    void getAllGenre();
    void getGenreByBookId(Long id);
    Optional<Genre> getGenreByName(String name);
}
