package ru.otus.task4.dao;

import ru.otus.task4.domain.Comment;

import java.util.List;


public interface CommentDao {
    List<Comment> getCommentByBookId(Long id);
    void putCommentByBookId(Long id, Comment comment);
}
