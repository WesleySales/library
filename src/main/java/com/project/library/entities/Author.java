package com.project.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.library.dtos.AuthorDTO;
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
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookListAuthor;

    public Author(){}


    public Author(String name) {
        this.id = id;
        this.nome = name;
        this.bookListAuthor = new ArrayList<>();
    }

    public void addBookToAuthor(List<Book> list){
        for(Book b: list){
            if(b.getAuthor().equals(this.getNome())){
                bookListAuthor.add(b);
            }
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", bookListAuthor=" + bookListAuthor +
                '}';
    }
}
