package com.project.library;


import com.project.library.entities.*;
import com.project.library.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.project.library")

public class LibraryApplication implements CommandLineRunner {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LB_RestRepository lb_restRepository;


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Author aut1 = new Author(null, "Machado de Assis");
		Author aut2 = new Author(null, "Guimaraes Rosa");
		Author aut3 = new Author(null, "Carolina Maria");
		authorRepository.save(aut1);
		authorRepository.save(aut2);
		authorRepository.save(aut3);

		Category cat1 = new Category(null, "Romance");
		Category cat2 = new Category(null, "Biografia");
		Category cat3 = new Category(null, "Ficção");
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);

		Book book1 = new Book(null, "Quarto de Despejo", aut3, cat2);
		Book book2 = new Book(null, "Grande Sertaõ", aut2, cat1);
		Book book3 = new Book(null, "O Alpinista", aut1, cat3);
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		LB_User user1 = new LB_User(null, "Joao",1234L,9898L);
		LB_User user2 = new LB_User(null, "Henrique",4566l,7198l);
		userRepository.save(user1);
		userRepository.save(user2);

		LB_Rest rest1 = new LB_Rest(null,user2,book2);
		LB_Rest rest2 = new LB_Rest(null,user2,book1);
		LB_Rest rest3 = new LB_Rest(null,user2,book3);
		lb_restRepository.save(rest1);
		lb_restRepository.save(rest2);
		lb_restRepository.save(rest3);

	}
}