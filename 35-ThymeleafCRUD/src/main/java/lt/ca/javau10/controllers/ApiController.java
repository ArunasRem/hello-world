package lt.ca.javau10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.ca.javau10.entities.Book;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/json")
	public Book getSimpleBook() {
		return new Book("MyTitle", "SomeAuthor", "thisisisbn");
	}

}
