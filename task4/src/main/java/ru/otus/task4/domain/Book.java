package ru.otus.task4.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {
    private final long id;
    private final String bookName;
    private final long keyAuthor;
    private final long keyGender;
}
