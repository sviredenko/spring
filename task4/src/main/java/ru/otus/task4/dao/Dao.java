package ru.otus.task4.dao;

import ru.otus.task4.domain.Book;

import java.util.List;

public interface Dao {
    int count();
    List<Book> getAllBooks();

    void insertBook(Book book);
    Book getBookById(Long id);
    void deleteBookById(Long id);
    void update(Book book);
}
