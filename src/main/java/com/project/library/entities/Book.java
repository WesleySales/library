package com.project.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.library.dtos.BookDTO;
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

    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_ID")
    private Author author;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "category_ID") //Se a categoria for deletada o livro pertencente a ela tambem sera
    private Category category;


    private boolean avaliable;
    public Book(){}
    public Book(BookDTO bookDTO){
        this.title= bookDTO.title();
        this.avaliable = true;
    }
    public Book(String titulo, Author author, Category category) {
        this.id = id;
        this.title = titulo;
        this.author = author;
        this.category = category;
        this.avaliable = true;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    public Long getId() {
        return id;
    }
    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }


    public String getTitle() {
        return title;
    }

    public void setCategory(Category category) {
        this.category = category;
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
