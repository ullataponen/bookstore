package fi.taponen.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.taponen.bookstore.domain.Book;
import fi.taponen.bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // To use MariaDB as test DB
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("It");
		System.out.println("list of books, " + books);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Stephen King");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Häräntappoase", "Anna-Leena Härkönen", "453342-11", 10.00, 1985);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("It");
		Long id = books.get(0).getId();
		System.out.println("id" + id);
		repository.deleteById(id);
		System.out.println("list of remaining books, " + books);
		assertThat(repository.count()).isEqualTo(1);
	}
}
