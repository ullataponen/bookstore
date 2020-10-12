package fi.taponen.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.taponen.bookstore.domain.Book;
import fi.taponen.bookstore.domain.BookRepository;
import fi.taponen.bookstore.domain.Category;
import fi.taponen.bookstore.domain.CategoryRepository;
import fi.taponen.bookstore.domain.User;
import fi.taponen.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	/*
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository){
		return(args)-> {
			
			// Create users: admin/admin user/user
			log.info("Create users");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@mail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			System.out.println("Save a couple of categories");
			crepository.save(new Category("horror"));
			crepository.save(new Category("fantasy"));
			crepository.save(new Category("sci-fi"));
		
			System.out.println("Save a couple of books");
			repository.save(new Book("It", "Stephen King", "1234156-45", 20.00, 1982, crepository.findByName("horror").get(0)));
			repository.save(new Book("Lord of the Rings", "J.R.R. Tolkien", "3146878-45", 35.00, 1971, crepository.findByName("fantasy").get(0)));
			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
			
		};
	}*/

}