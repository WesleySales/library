package com.project.library.services;

import com.project.library.dtos.AuthorDTO;
import com.project.library.dtos.CategoryDTO;
import com.project.library.entities.Author;
import com.project.library.entities.Category;
import com.project.library.repositories.AuthorRepository;
import com.project.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryDTO data){
        Category newCategory = new Category(data);
        categoryRepository.save(newCategory);
        return newCategory;
    }
    public List<Category> getAll(){
        List<Category> list = categoryRepository.findAll();
        return list;
    }
    public Category getById(Long id){
        Category getCategory = categoryRepository.findById(id).get();
        return getCategory;
    }

    public Category getByName(String name){
        Category categoryByName = new Category();
        for(Category category: categoryRepository.findAll()){
            if(category.getName().equalsIgnoreCase(name)){
                categoryByName = category;
            }
        }
        return categoryByName;
    }
}
