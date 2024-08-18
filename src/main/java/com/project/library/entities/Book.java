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

    @ManyToOne
    @JoinColumn(name = "category_ID") //Se a categoria for deletada o livro pertencente a ela tambem sera
    private Category category;

//    @OneToMany(mappedBy = "book_Rest")
//    private List<LB_Rest> lb_rest = new ArrayList<>();

    public Book(){}
    public Book(BookDTO bookDTO){
        this.id= bookDTO.id();
        this.title= bookDTO.title();
    }
    public Book(Long id, String titulo, Author author, Category category) {
        this.id = id;
        this.title = titulo;
        this.author = author;
        this.category = category;
    }

    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
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
