package ru.otus.task4.dao;

import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDaoImp implements AuthorDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Author> getAllAuthor(){
        TypedQuery<Author> query = em.createQuery("select s from Author s",Author.class);
        return query.getResultList();
    }
}
