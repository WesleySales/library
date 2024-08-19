package com.project.library.services;

import com.project.library.dtos.LB_UserDTO;
import com.project.library.entities.LB_User;
import com.project.library.repositories.LB_RentRepository;
import com.project.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LB_UserService {

    @Autowired
    private UserRepository repository;
    public LB_User createUser(LB_UserDTO data){
        LB_User newUser = new LB_User(data);
        repository.save(newUser);
        return newUser;
    }
    public LB_User getById(Long id){
        LB_User getUser = repository.findById(id).get();
        repository.save(getUser);
        return getUser;
    }



}
