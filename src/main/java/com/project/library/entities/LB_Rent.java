package com.project.library.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
public class LB_Rent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_ID", nullable = false)
    private LB_User user;

    @ManyToOne
    @JoinColumn(name = "book_ID")
    private Book book_Rent;

    private LocalDate dateRent;
    private LocalDate dateReturn ;

    public LB_Rent(){}


    public LB_Rent(LB_User user,Book book_Rent) {
        this.user = user;
        this.book_Rent = book_Rent;
        this.dateRent = LocalDate.now();
        this.dateReturn = LocalDate.now().plusDays(7);
        book_Rent.setAvaliable(false);
    }

    public Long getId() {
        return id;
    }

    public LB_User getUser() {
        return user;
    }

    public LocalDate getDateRent() {
        return dateRent;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public Book getBook_Rent() {
        return book_Rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LB_Rent lbRent = (LB_Rent) o;
        return Objects.equals(id, lbRent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
