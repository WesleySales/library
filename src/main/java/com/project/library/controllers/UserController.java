package com.project.library.controllers;


import com.project.library.entities.LB_User;
import com.project.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<LB_User>> findAll(){
        List<LB_User> list = userRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LB_User> findById(Long id){
        LB_User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }
}
