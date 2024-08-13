package com.project.library.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class LB_Rest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private LB_User user;

    @ManyToOne
    @JoinColumn(name = "book_ID")
    private Book book_Rest;

//    private LocalDate dataEmprestimo;
//    private LocalDate dataDevolucao;


    public LB_Rest(){}

    public LB_Rest(Long id, LB_User user,Book book_Rest) {
        this.id = id;
        this.user = user;
        this.book_Rest = book_Rest;
    }

    public Long getId() {
        return id;
    }

//    public User getUser() {
//        return user;
//    }

    public Book getBook_Rest() {
        return book_Rest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LB_Rest lbRest = (LB_Rest) o;
        return Objects.equals(id, lbRest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
