package com.project.library.controllers;

import com.project.library.dtos.AuthorDTO;
import com.project.library.dtos.BookDTO;
import com.project.library.dtos.CategoryDTO;
import com.project.library.entities.Author;
import com.project.library.entities.Book;
import com.project.library.repositories.BookRepository;
import com.project.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;
    private BookRepository bookRepository;


    @PostMapping
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO, AuthorDTO authorDTO, CategoryDTO categoryDTO){
        Book newBook = bookService.createBook(bookDTO, authorDTO,categoryDTO);
        return ResponseEntity.ok().body(newBook);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable  Long id, @RequestBody BookDTO bookDTO){
        Book newBook = bookService.getById(id);
        newBook.setTitulo(bookDTO.title());
        bookRepository.save(newBook);
        return ResponseEntity.ok().body(newBook);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable  Long id){
        Book book = findById(id).getBody();
        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Book> list = bookService.getAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(book);
    }
}
