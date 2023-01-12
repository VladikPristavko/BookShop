package com.bookshop.controllers;

import com.bookshop.data.Book;
import com.bookshop.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@Controller
public class MainPageController {
    private final BookService bookService;
    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }
    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBookData();
    }
    @GetMapping("/")
    public String mainPage(){
//        model.addAttribute("bookData", bookService.getBookData());
//        model.addAttribute("searchPlaceholder", "new search placeholder");
//        model.addAttribute(
//                "serverTime",
//                new SimpleDateFormat("HH:mm:ss").format(new Date()));
//        model.addAttribute("placeholderTextPart2", "server");
//        model.addAttribute("messageTemplate", "searchbar.placeholder2");
        return "index";
    }
}
