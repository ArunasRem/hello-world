package lt.ca.javau10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.ca.javau10.entities.Book;
import lt.ca.javau10.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	//CRUD
	//Create
	//Read
	//Update
	//Delete
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping
	public String listBooks(Model model) {
		model.addAttribute("books", service.findAllBooks());
				
				return "book/list";
	}
		
	
	
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("book", new Book());
		return "book/create";
	}
	
	@PostMapping
	public String createBook(@ModelAttribute Book book) {
		service.saveBook(book);
		
		
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Book book = service.getBookById(id);
		model.addAttribute("book", book);
		
		return "book/edit"; 
	}
	
	@PostMapping("/edit/{id}")
	public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
		service.updateBook(id, book);
		return "redirect:/books";
    }
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		service.deleteBookById(id);
		return "redirect:/books";
    
	}
}
