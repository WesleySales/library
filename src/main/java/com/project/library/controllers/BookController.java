package com.project.library.controllers;

import com.project.library.entities.Book;
import com.project.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(Long id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(book);
    }
}
