package ru.otus.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.task4.domain.Comment;

import java.util.List;


public interface CommentRepository {
    List<Comment> findCommentByBookId(Long id);
    void putCommentByBookId(Long id, Comment comment);
}
