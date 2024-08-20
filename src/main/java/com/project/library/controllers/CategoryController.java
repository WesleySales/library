package com.project.library.controllers;


import com.project.library.dtos.CategoryDTO;
import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookRepository bookRepository;


    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryDTO categoryDTO){
        Category newCategory = new Category(categoryDTO);
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        Category newCategory = categoryRepository.findById(id).get();
        newCategory.setName(categoryDTO.nameCategory());
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().body(newCategory);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        Category deleteCat = categoryRepository.findById(id).get();
        List<Book> bookList = deleteCat.getBookList();
        for(Book book: bookList){
            book.setCategory(null);
            bookRepository.save(book);
        }
        categoryRepository.delete(deleteCat);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryRepository.findById(id).get();
        return ResponseEntity.ok().body(category);
    }
}
