package ru.otus.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.AuthorDao;
import ru.otus.task4.domain.Author;

import java.util.List;


@Service
public class ServiceAuthorImpl implements ServiceAuthor{

    private final  AuthorDao dao;

    @Autowired
    public ServiceAuthorImpl(AuthorDao dao){
        this.dao = dao;
    }
    @Override
    public void getAllAuthor(){
        List<Author> res =  this.dao.getAllAuthor();
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i).getId() + "."  + res.get(i).getAuthor());
        }
    }
}
