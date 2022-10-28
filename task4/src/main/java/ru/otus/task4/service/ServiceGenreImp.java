package ru.otus.task4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.GenreDao;
import ru.otus.task4.domain.Genre;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceGenreImp implements ServiceGenre{
    GenreDao genreDao;


    @Override
    public void getAllGenre(){
        List<Genre> genres = this.genreDao.getAllGenre();
        for(int i = 0; i < genres.size(); i++){
            System.out.println(genres.get(i).getId() + "." +genres.get(i).getGenre());
        }
    }
    @Override
    public void getGenreByBookId(Long id){
        List<Genre> genres = this.genreDao.getGenreByBookId(id);
        for(int i = 0; i < genres.size(); i++){
            System.out.println(genres.get(i).getId() + "." + genres.get(i).getGenre());
        }
    }
}
