package ru.otus.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.task4.domain.Author;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Genre;
import ru.otus.task4.repository.BookRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BookDaoTest")
@DataJpaTest
@Import(BookRepository.class)
public class BookDaoImpTest {
    @Autowired
    private BookRepository dao;

    @Autowired
    TestEntityManager em;

    @BeforeEach
    void setUp(){


    }

    @DisplayName("Check get all book")
    @Test
    void shouldCheckAllBooks(){
        assertThat(dao.findAll().size()).isEqualTo(1);
    }

    @DisplayName("Check save book")
    @Test
    void shouldSaveBook(){
        Book book = new Book();
        book.setId(0);
        book.setBookName("ziba");
        List<Genre> genre = new ArrayList<>();
        Genre genre1 = new Genre(0,"comedy");
        genre.add(genre1);
        book.setGenres(genre);
        List<Author> author = new ArrayList<>();
        Author author1 = new Author(0,"Pushkin");
        author.add(author1);
        book.setAuthors(author);
        dao.save(book);

        assertThat(dao.findAll().size()).isEqualTo(2);
        assertThat(dao.findById(2l).isPresent()).isEqualTo(true);
    }


}
