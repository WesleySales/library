package com.project.library.controllers;

import com.project.library.entities.Author;
import com.project.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        List<Author> list = authorRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> findById(Long id){
        Author author = authorRepository.findById(id).get();
        return ResponseEntity.ok().body(author);
    }
}
