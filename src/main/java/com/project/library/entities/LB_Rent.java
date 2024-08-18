package com.project.library.entities;

import com.project.library.dtos.LB_RentDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
    private Book book_Rest;

    private LocalDate dateRent = LocalDate.now() ;
    private LocalDate dateReturn = dateRent.plusDays(7);


    public LB_Rent(){}
//    public LB_Rent(LB_RentDTO){
//        this.id = id;
//        this.user = user;
//        this.book_Rest = book_Rent;
//        this.dateRent = getDateRent();
//        this.dateReturn = getDateReturn();
//    }

    public LB_Rent(Long id, LB_User user,Book book_Rent) {
        this.id = id;
        this.user = user;
        this.book_Rest = book_Rent;
        this.dateRent = getDateRent();
        this.dateReturn = getDateReturn();
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

    public Book getBook_Rest() {
        return book_Rest;
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
