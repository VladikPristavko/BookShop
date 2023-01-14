package com.bookshop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String,List<Author>> getAuthorsData() {
        return authorRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"))
                .stream().collect(Collectors.groupingBy(
                author -> String.valueOf(author.getLastName().charAt(0)))
                );
    }
}
