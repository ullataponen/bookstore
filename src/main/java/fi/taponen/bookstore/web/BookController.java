package fi.taponen.bookstore.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//Log in
	@GetMapping(value ="/login")
	public String logIn(Model model) {
		model.addAttribute("title", "Log In");
		return "login";
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
	public String save(@Valid Book book, BindingResult bindingRes, Model model) {
		if(bindingRes.hasErrors()) {
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
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
	
	//Get all with REST
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	//find one by id with REST
	@GetMapping(value = "/books/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
}