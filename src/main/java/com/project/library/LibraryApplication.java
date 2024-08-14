package com.project.library;


import com.project.library.entities.*;
import com.project.library.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	LB_RentRepository lb_rentRepository;


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Author aut1 = new Author(null, "Machado de Assis");
		Author aut2 = new Author(null, "Guimaraes Rosa");
		Author aut3 = new Author(null, "Carolina Maria");
		Author aut4 = new Author(null, "Rick Riordan");
		authorRepository.save(aut1);
		authorRepository.save(aut2);
		authorRepository.save(aut3);

		Category cat1 = new Category(null, "Romance");
		Category cat2 = new Category(null, "Biografia");
		Category cat3 = new Category(null, "Ficção");
		Category cat4 = new Category(null, "Drama");
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		categoryRepository.save(cat3);

		Book book1 = new Book(null, "Quarto de Despejo", aut3, cat2);
		Book book2 = new Book(null, "Grande Sertaõ", aut2, cat1);
		Book book3 = new Book(null, "O Alpinista", aut1, cat3);
		Book book4 = new Book(null, "Dom Casmurro", aut1, cat3);
		Book book5 = new Book(null, "Memorias Postumas", aut1, cat3);
		Book book6 = new Book(null, "Quincas Borba", aut1, cat3);
		Book book7 = new Book(null, "Primeiras Estórias", aut2, cat3);
		Book book8 = new Book(null, "A Terceira Margem do Rio", aut2, cat1);
		Book book9 = new Book(null, "Corpo de Baile", aut2, cat1);

		List<Book> bookList = new ArrayList<>();

		bookList.addAll(Arrays.asList(book1,book2,book3,book4,book5, book5,
				book6,book7,book8, book9));

		aut1.addBookToAuthor(bookList);
		aut2.addBookToAuthor(bookList);
		aut3.addBookToAuthor(bookList);

		bookRepository.saveAll(bookList);

		LB_User user1 = new LB_User(null, "Joao",1234L,9898L);
		LB_User user2 = new LB_User(null, "Henrique",4566l,7198l);
		userRepository.save(user1);
		userRepository.save(user2);

		LB_Rent rent1 = new LB_Rent(null,user2,book5);
		LB_Rent rent2 = new LB_Rent(null,user2,book1);
		LB_Rent rent3 = new LB_Rent(null,user2,book3);
		lb_rentRepository.save(rent1);
		lb_rentRepository.save(rent2);
		lb_rentRepository.save(rent3);

	}
}