package ru.otus.task4.dao;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentDaoImp implements CommentDao{
    private final BookDao bookDao;

    @Override
    public List<Comment> getCommentByBookId(Long id){
        Optional<Book> book = this.bookDao.getBookById(id);
        if(book.isPresent()){
            return book.get().getComments();
        }
        else{
            return new ArrayList<>();
        }

    }
}
