package fi.taponen.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.taponen.bookstore.domain.Book;
import fi.taponen.bookstore.domain.BookRepository;
import fi.taponen.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
		
	//Get all
	@GetMapping(value={"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("title", "Book List");
		model.addAttribute("books", repository.findAll());
		model.addAttribute("categories", crepository.findAll());
		return "booklist";
	}
	
	//Add new
	@GetMapping(value="addbook")
	public String addBook(Model model) {
		model.addAttribute("title", "Add Book");
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	//Save new or edited book
	@PostMapping(value="/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	//Delete
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Edit
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("title", "Edit Book");
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
}