package com.bookshop.controllers;

import com.bookshop.data.Author;
import com.bookshop.data.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsController {
    private final AuthorService authorService;
    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorList(){
        return authorService.getAuthorsData();
    }
    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }
}
