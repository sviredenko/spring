package ru.otus.task4.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Gendre {
    private final long id;
    private final String gendre;
}
