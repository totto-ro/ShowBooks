package com.codingdojo.showbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.showbooks.models.Book;
import com.codingdojo.showbooks.repositories.BookRepository;



@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook( Book book ) {
        return bookRepository.save( book );
    }
    
    // update a book
    public Book updateBook( Long id, String title, String description, String lang, int pages ) {
    	Book book = new Book (id, title, description, lang, pages);
        return bookRepository.save(book);
    }
    
 // update a book2
    public Book updateBook2(Book book) {
    	//Book book = new Book (id, title, description, lang, pages);
        return bookRepository.save(book);
    }
    
    // retrieves a book
    public Book findBook( Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } 
        else {
        	return null;
        }
    }
        
    public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        }
	}
	
	

}
