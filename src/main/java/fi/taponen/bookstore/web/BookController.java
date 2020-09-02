package fi.taponen.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping(value = "index")
	public String returnIndex() {
		return "";
	}
}
