package com.project.library.services;

import com.project.library.dtos.AuthorDTO;
import com.project.library.dtos.BookDTO;
import com.project.library.dtos.CategoryDTO;
import com.project.library.entities.Author;
import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.repositories.AuthorRepository;
import com.project.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;


    public Book createBook(BookDTO dataBook, AuthorDTO dataAuthor, CategoryDTO dataCategory){

        Author author = authorService.getByName(dataAuthor.nameAuthor());
        if(author == null){
            author = authorService.createAuthor(dataAuthor);
        }

        Category category=categoryService.getByName(dataCategory.nameCategory());
        if(category==null){
           category = categoryService.createCategory(dataCategory);
        }

        Book newBook = new Book(dataBook.title(),author,category);
        bookRepository.save(newBook);
        return newBook;
    }
    public List<Book> getAll(){
        List<Book> list = bookRepository.findAll();
        return list;
    }

    public Book getById(Long id){
        Book getBook = bookRepository.findById(id).get();
        return getBook;
    }

//    public boolean verificarDisponibilidade(Long id){
//        Book book = bookRepository.findById(id).get();
//        if(Book books: )
//        return book.isAvaliable();
//    }

}
