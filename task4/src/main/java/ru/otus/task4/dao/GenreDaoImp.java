package ru.otus.task4.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class GenreDaoImp implements GenreDao {

    @PersistenceContext
    EntityManager em;

    BookDao bookDao;

    @Override
    public List<Genre> getAllGenre() {
        TypedQuery<Genre> query = em.createQuery("select s from Genre s", Genre.class);
        return query.getResultList();
    }

    @Override
    public List<Genre> getGenreByBookId(Long id) {
        Optional<Book> book = this.bookDao.getBookById(id);
       if(book.isPresent())
           return book.get().getGenres();
       else
           return new ArrayList<Genre>();
    }

}
