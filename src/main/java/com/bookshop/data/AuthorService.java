package com.bookshop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String,List<Author>> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors ORDER BY last_name",
                (ResultSet resultSet, int rowNumber) -> {
            Author author = new Author();
            author.setId(resultSet.getInt("id"));
            author.setFirstName(resultSet.getString("first_name"));
            author.setLastName(resultSet.getString("last_name"));
            return author;
                });
        return authors.stream()
                .collect(Collectors.groupingBy(
                        author -> String.valueOf(author.getLastName().charAt(0))
                ));
    }
}
