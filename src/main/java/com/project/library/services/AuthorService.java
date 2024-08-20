package com.project.library.services;

import com.project.library.dtos.AuthorDTO;
import com.project.library.entities.Author;
import com.project.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(AuthorDTO data){
        Author newAuthor = new Author(data.nameAuthor());
        authorRepository.save(newAuthor);
        return newAuthor;
    }
    public List<Author> getAll(){
        List<Author> list = authorRepository.findAll();
        return list;
    }
    public Author getById(Long id){
        Author getAuthor = authorRepository.findById(id).get();
        return getAuthor;
    }

    public Author getByName(String name){
        Author authorByName = null;
        for(Author author: authorRepository.findAll()){
            if(author.getNome().equalsIgnoreCase(name)){
                authorByName = author;
            }
        }
        return authorByName;
    }
}
