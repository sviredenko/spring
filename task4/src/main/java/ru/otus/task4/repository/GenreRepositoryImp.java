package ru.otus.task4.repository;

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
public class GenreRepositoryImp implements GenreRepository {

    @PersistenceContext
    EntityManager em;

    BookRepository bookRepository;

    @Override
    public List<Genre> getAllGenre() {
        TypedQuery<Genre> query = em.createQuery("select s from Genre s", Genre.class);
        return query.getResultList();
    }

    @Override
    public List<Genre> getGenreByBookId(Long id) {
        Optional<Book> book = this.bookRepository.getBookById(id);
       if(book.isPresent())
           return book.get().getGenres();
       else
           return new ArrayList<Genre>();
    }

    @Override
    public Optional<Genre> getGenreByName(String name){
        Query query = em.createQuery("select s from Genre s where s.genre = :genre");
        query.setParameter("genre", name);
        List<Genre> genres = query.getResultList();
        if(genres.isEmpty()){
             return Optional.empty();
        }
        else
            return Optional.ofNullable(genres.get(0));
    }
}
