package com.project.library.controllers;

import com.project.library.dtos.AuthorDTO;
import com.project.library.entities.Author;
import com.project.library.repositories.AuthorRepository;
import com.project.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity createAuthor(@RequestBody AuthorDTO authorDTO){
        Author newAuthor=authorService.createAuthor(authorDTO);
        return ResponseEntity.ok().body(newAuthor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable  Long id, @RequestBody AuthorDTO authorDTO){
        Author newAuthor = authorRepository.findById(id).get();
        newAuthor.setNome(authorDTO.name());
        authorRepository.save(newAuthor);
        return ResponseEntity.ok().body(newAuthor);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable  Long id){
        Author newAuthor = authorRepository.findById(id).get();
        authorRepository.delete(newAuthor);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity findAll(){
        List<Author> list = authorService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(Long id){
        Author author = authorService.getById(id);
        return ResponseEntity.ok().body(author);
    }
}
