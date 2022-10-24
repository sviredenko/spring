package ru.otus.task4.service;

public interface ServiceBook {
    void getAllBook();

    void deleteBookById(Long id);
    void getBookById(Long Id);
    void saveBook();
    int getNumberOfBook();
}
