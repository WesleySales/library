package com.project.library.services;

import com.project.library.dtos.LB_RentDTO;
import com.project.library.entities.Book;
import com.project.library.entities.LB_Rent;
import com.project.library.entities.LB_User;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.LB_RentRepository;
import com.project.library.repositories.UserRepository;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LB_RentService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LB_RentRepository lb_rentRepository;
    @Autowired
    private UserRepository userRepository;


    public LB_Rent createRent(LB_RentDTO data){

        if (data.userID() == null || data.bookID() == null) {
            throw new IllegalArgumentException("Os campos Usuário e Livro não podem ser nulos");
        } else {

            LB_User user = userRepository.findById(data.userID())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            Book book = bookRepository.findById(data.bookID())
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado"));


            LB_Rent newRent = new LB_Rent(user, book);
            lb_rentRepository.save(newRent);
            return newRent;
        }
    }

    public List<LB_Rent> getAll (){
        List<LB_Rent> list = lb_rentRepository.findAll();
        return list;
    }
     public LB_Rent getById (Long id){
        LB_Rent getRent = lb_rentRepository.findById(id).get();
        return getRent;
    }



}
