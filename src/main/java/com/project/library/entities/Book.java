package com.project.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_ID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

//    @OneToMany(mappedBy = "book_Rest")
//    private List<LB_Rest> lb_rest = new ArrayList<>();

    public Book(){}
    public Book(Long id, String titulo, Author author, Category category) {
        this.id = id;
        this.titulo = titulo;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
