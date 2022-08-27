package ru.otus.task4.dao;

import ru.otus.task4.domain.Book;

import java.util.List;

public interface Dao {
    public int count();
    public List<Book> getAllBooks();

    public void insertBook(Book book);
    public Book getBookById(Long id);
    public void deleteBookById(Long id);
}
