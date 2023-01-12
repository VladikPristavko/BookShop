package com.bookshop.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBookData() {
        return jdbcTemplate.query(
                "SELECT * FROM books",
                (ResultSet resultSet, int rowNumber) -> {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setAuthor(resultSet.getString("author_id"));
            book.setTitle(resultSet.getString("title"));
            book.setPriceOld(resultSet.getString("price_old"));
            book.setPrice(resultSet.getString("price"));
            return book;
        });
    }
}
