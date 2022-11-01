package ru.otus.task4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.task4.domain.Comment;

import java.util.List;


public interface CommentDao extends JpaRepository<Comment, Long> {

    @Query("select b.comments from Book b where b.id = :id")
    List<Comment> findCommentByBookId(@Param("id")Long id);
}
