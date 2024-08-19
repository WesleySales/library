package com.project.library.entities;

import com.project.library.dtos.LB_UserDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class LB_User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long CPF;
    private Long phone;

//    @OneToMany(mappedBy = "book_rest")
//    private List<LB_Rest> lb_rest = new ArrayList<>();

    public LB_User(){}

    public LB_User(LB_UserDTO data) {
        this.id = data.id();
        this.name = data.name();
        this.CPF = data.CPF();
        this.phone = data.phone();
    }
    
    public LB_User(Long id, String name, Long CPF, Long phone) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.phone = phone;
        }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Long getCPF() {
        return CPF;
    }

    public Long getPhone() {
        return phone;
    }
//
//    public List<LB_Rest> getLb_rest() {
//        return lb_rest;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LB_User lbUser = (LB_User) o;
        return Objects.equals(id, lbUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
