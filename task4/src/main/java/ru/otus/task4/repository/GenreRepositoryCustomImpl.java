package ru.otus.task4.repository;

import lombok.RequiredArgsConstructor;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GenreRepositoryCustomImpl implements GenreRepositoryCustom{

    private final BookRepository bookRepository;

    @Override
    public List<Genre> findByBookId(Long id){
        Optional<Book> book = this.bookRepository.findById(id);
        if(book.isPresent())
            return book.get().getGenres();
        else
            return new ArrayList<Genre>();
    }


}
