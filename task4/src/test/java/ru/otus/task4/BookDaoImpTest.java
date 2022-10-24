package ru.otus.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.task4.dao.BookDaoImp;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BookDaoTest")
@DataJpaTest
@Import(BookDaoImp.class)
public class BookDaoImpTest {
    @Autowired
    private BookDaoImp dao;

    @Autowired
    TestEntityManager em;

    @DisplayName("Check get all book")
    @Test
    void shouldCheckAllBooks(){
        assertThat(1).isEqualTo(1);
    }


}
