package ru.otus.task4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.task4.repository.GenreRepository;
import ru.otus.task4.domain.Genre;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceGenreImp implements ServiceGenre{
    GenreRepository genreDao;


    @Transactional
    @Override
    public void getAllGenre(){
        List<Genre> genres = this.genreDao.getAllGenre();
        for(int i = 0; i < genres.size(); i++){
            System.out.println(genres.get(i).getId() + "." +genres.get(i).getGenre());
        }
    }

    @Transactional
    @Override
    public void getGenreByBookId(Long id){
        List<Genre> genres = this.genreDao.getGenreByBookId(id);
        for(int i = 0; i < genres.size(); i++){
            System.out.println(genres.get(i).getId() + "." + genres.get(i).getGenre());
        }
    }

    @Transactional
    @Override
    public Optional<Genre> getGenreByName(String name){
         return this.genreDao.getGenreByName(name);
    }
}
