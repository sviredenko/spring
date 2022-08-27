package ru.otus.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.task4.dao.Dao;
import ru.otus.task4.dao.DaoJdbc;
import ru.otus.task4.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao test")
@JdbcTest
@Import(DaoJdbc.class)
public class DaoJdbcTest {

    private static final int EXPECTED_PERSONS_COUNT = 3;

    @Autowired
    private Dao dao;

    @DisplayName("Проверка на кол-во записей")
    @Test
    void shouldReturnExpectedBookCount() {
        int actualPersonsCount = dao.count();
        assertThat(actualPersonsCount).isEqualTo(EXPECTED_PERSONS_COUNT);
    }
    @DisplayName("Проверка на добавление записи")
    @Test
    void shouldInsertBook() {
        Book expectedBook = new Book(4,"Hero",1,1);
        dao.insertBook(expectedBook);
        Book actualBook = dao.getBookById(Long.valueOf(4));
        assertThat(actualBook)
                .hasFieldOrPropertyWithValue("bookName","Hero");
    }

    @DisplayName("Проверка на получение записи")
    @Test
    void shouldGetBook() {
        Book actualBook = dao.getBookById(Long.valueOf(1));
        assertThat(actualBook)
                .hasFieldOrPropertyWithValue("bookName","The Catcher in the Rye ");
    }


}
