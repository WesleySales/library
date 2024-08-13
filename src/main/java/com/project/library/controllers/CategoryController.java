package com.project.library.controllers;


import com.project.library.entities.Category;
import com.project.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(Long id){
        Category category = categoryRepository.findById(id).get();
        return ResponseEntity.ok().body(category);
    }
}
