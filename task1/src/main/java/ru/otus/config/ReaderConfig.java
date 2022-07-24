package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.dao.Reader;

import java.io.IOException;

@Configuration
public class ReaderConfig {
    @Bean()
    public Reader reader(@Value("${filename}") String str) throws IOException {
        return new Reader(str);
    }
}
