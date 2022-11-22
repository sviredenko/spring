package ru.otus.task4.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Book;
import ru.otus.task4.domain.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final BookRepository bookRepository;

    @Override
    public List<Comment> findCommentByBookId(Long id){
        Optional<Book> book = this.bookRepository.findById(id);
        if(book.isPresent()){
            return book.get().getComments();
        }
        else{
            return new ArrayList<>();
        }

    }
    @Override
    public void putCommentByBookId(Long id, Comment comment){
        Optional<Book> book = this.bookRepository.findById(id);
        if(book.isPresent()) {
            List<Comment> comments = book.get().getComments();
            comments.add(comment);
            book.get().setComments(comments);
            this.bookRepository.save(book.get());
        }

    }
}
