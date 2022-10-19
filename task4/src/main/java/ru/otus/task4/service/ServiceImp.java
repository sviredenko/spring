package ru.otus.task4.service;

public interface ServiceImp {
    void getAllBook();
    void insertBook();
    void updateBookById();
    void deleteBookById(Long id);
    void getBookById(Long id);
    void numberOfBook();
    void getAllAuthor();
    void getAllGenre();
}
