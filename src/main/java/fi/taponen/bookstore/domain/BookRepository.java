package fi.taponen.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
}

//selaimeen: http://localhost:8080/api/books/search/findByTitle?title=It
	//List<Book> findByTitle(@Param("title") String title);
