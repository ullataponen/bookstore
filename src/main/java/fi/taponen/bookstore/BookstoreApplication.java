package fi.taponen.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.taponen.bookstore.domain.Book;
import fi.taponen.bookstore.domain.BookRepository;
import fi.taponen.bookstore.domain.Category;
import fi.taponen.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository){
		return(args)-> {
			System.out.println("Save a couple of categories");
			crepository.save(new Category("horror"));
			crepository.save(new Category("fantasy"));
		
			System.out.println("Save a couple of books");
			repository.save(new Book("It", "Stephen King", "1234156-45", 20.00, 1982, crepository.findByName("horror").get(0)));
			repository.save(new Book("Lord of the Rings", "J.R.R. Tolkien", "3146878-45", 35.00, 1971, crepository.findByName("fantasy").get(0)));
			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
