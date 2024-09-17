package lt.ca.javau10.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lt.ca.javau10.entities.Book;
import lt.ca.javau10.repository.BookRepository;

@Service
public class BookService {
	
	BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		
	}
	
	
	
	public List<Book> findAllBooks(){ 
		return bookRepository.findAll();
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
		
	} 

	public Book getBookById(Long id) {
		 
		
		return bookRepository
				.findById(id)
				.orElse(new Book());
	}

	public void updateBook(Long id, Book newBook) {
		Book oldBook = getBookById(id);
		oldBook.setTitle( newBook.getTitle() );
		oldBook.setAuthor( newBook.getAuthor() );
		oldBook.setIsbn( newBook.getIsbn() );
		
		bookRepository.save(oldBook);
	}

	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
		
		
	}

	

}