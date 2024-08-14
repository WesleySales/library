package com.project.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> bookListAuthor;

    public Author(){}

    public Author(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.bookListAuthor = new ArrayList<>();
    }

    public void addBookToAuthor(List<Book> list){
        for(Book b: list){
            if(b.getAuthor().equals(this.getNome())){
                bookListAuthor.add(b);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public List<Book> getBookList() {
        return bookListAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
