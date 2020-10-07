package fi.taponen.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.junit4.SpringRunner;

import fi.taponen.bookstore.domain.Book;
import fi.taponen.bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		
		System.out.println("kaikki kirjat, " + repository.findAll().toString());

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
		long id = books.get(0).getId();
		System.out.println("id" + id);
		repository.deleteById(id);
		System.out.println("list of remaining books, " + books);
		assertThat(books).hasSize(0);
	}
}
