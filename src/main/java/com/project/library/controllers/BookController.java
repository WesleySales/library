package com.project.library.controllers;

import com.project.library.dtos.AuthorDTO;
import com.project.library.dtos.BookDTO;
import com.project.library.entities.Author;
import com.project.library.entities.Book;
import com.project.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @PostMapping
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO){
        Book newBook = new Book(bookDTO);
        bookRepository.save(newBook);
        return ResponseEntity.ok().body(newBook);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable  Long id, @RequestBody BookDTO bookDTO){
        Book newBook = bookRepository.findById(id).get();
        newBook.setTitulo(bookDTO.title());
        bookRepository.save(newBook);
        return ResponseEntity.ok().body(newBook);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable  Long id){
        Book newBook = bookRepository.findById(id).get();
        bookRepository.delete(newBook);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(book);
    }
}
