package com.bookshop.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();
    public String toString(){
        return firstName + " " + lastName;
    }
}
