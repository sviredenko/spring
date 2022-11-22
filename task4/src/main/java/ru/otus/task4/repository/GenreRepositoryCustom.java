package ru.otus.task4.repository;

import ru.otus.task4.domain.Genre;

import java.util.List;

public interface GenreRepositoryCustom  {
    List<Genre> findByBookId(Long id);
}
