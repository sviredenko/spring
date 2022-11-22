package ru.otus.task4.repository;

import ru.otus.task4.domain.Comment;

import java.util.List;


public interface CommentRepository {
    List<Comment> getCommentByBookId(Long id);
    void putCommentByBookId(Long id, Comment comment);
}
