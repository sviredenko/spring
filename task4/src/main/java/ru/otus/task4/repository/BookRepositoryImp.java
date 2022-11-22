package ru.otus.task4.repository;

import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;



@Repository
public class BookRepositoryImp implements BookRepository {

    @PersistenceContext
    private  EntityManager em;




    @Override
    public long count() {
        Query query =em.createQuery("select count(*) from Book s");
        return (long) query.getSingleResult();
    }


    @Override
    public List<Book> getAllBooks(){
        TypedQuery<Book> query =  em.createQuery("select s from Book s ", Book.class);
        return query.getResultList();
    }


    @Override
    public void deleteBookById(Long id) {
        Query query = em.createQuery("delete from Book s where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }



    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }


    @Override
    public Book saveBook(Book book){
        if(book.getId() == 0 ){
            em.persist(book);
            return book;
        }
        else{
            return em.merge(book);
        }
    }

}
