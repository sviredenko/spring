package ru.otus.task4.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Comment;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
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
    @Override
    public void putCommentByBookId(Long id, Comment comment){
        Optional<Book> book = this.bookDao.getBookById(id);
        if(book.isPresent()) {
            List<Comment> comments = book.get().getComments();
            comments.add(comment);
            book.get().setComments(comments);
            this.bookDao.saveBook(book.get());
        }

    }
}
