package ru.otus.task4.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import ru.otus.task4.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoJdbc implements Dao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final JdbcOperations jdbc;

    public DaoJdbc(NamedParameterJdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public List<Book> getAllBooks(){
        return namedParameterJdbcOperations.query("select * from books", new BookMapper());
    }
    @Override
    public void insertBook(Book book){
        namedParameterJdbcOperations.update("insert into books " +
                        "(id,`bookName`,keyAuthor,keyGender) " +
                        "values (:id, :bookName,:keyAuthor,:keyGender)",
                Map.of("id",book.getId(),
                        "bookName",book.getBookName(),
                        "keyAuthor",book.getKeyAuthor(),
                        "keyGender",book.getKeyGender()));
    }
    @Override
    public Book getBookById(Long id){
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from books where id = :id", params, new BookMapper()
        );

    }
    public void deleteBookById(Long id){
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );

    }

    @Override
    public void update(Book book) {
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("id",book.getId());
        params.put("bookName",book.getBookName());
        params.put("keyAuthor",book.getKeyAuthor());
        params.put("keyGender",book.getKeyGender());
        namedParameterJdbcOperations.update("update BOOKS set bookName = :bookName, keyAuthor = :keyAuthor, keyGender = :keyGender where id = :id",params);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("bookName");
            long keyAuthor = resultSet.getLong("keyAuthor");
            long keyGender = resultSet.getLong("keyGender");
            return new Book(id, name, keyAuthor, keyGender );
        }
    }

}
