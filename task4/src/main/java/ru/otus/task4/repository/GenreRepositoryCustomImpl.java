package ru.otus.task4.repository;

import lombok.RequiredArgsConstructor;
import ru.otus.task4.domain.Genre;

import java.util.List;

@RequiredArgsConstructor
public class GenreRepositoryCustomImpl implements GenreRepositoryCustom{

    private final GenreRepository genreRepository;
    @Override
    List<Genre> findByBookId(Long id){

    }


}
