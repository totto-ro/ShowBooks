package com.codingdojo.showbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.showbooks.models.Book;
import com.codingdojo.showbooks.services.BookService;



@RestController
public class BooksApi {
	//Attributes
	private final BookService bookService;
	
	//Constructor
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    
    //Retrieves all books
    @RequestMapping( value = "/api/books", method=RequestMethod.GET )
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    
    
  //Get book by id method
    @RequestMapping( value = "/api/books/{id}", method=RequestMethod.GET )
    public Book show(@PathVariable( "id" ) Long id ) {
        Book book = bookService.findBook( id );
        return book;
    }
    
    //Create method
    @RequestMapping( value="/api/books", method=RequestMethod.POST )
    public Book create( @RequestParam( value="title" ) String title, 
    				    @RequestParam( value="description" ) String desc, 
    				    @RequestParam( value="language" ) String lang, 
    				    @RequestParam( value="pages" ) Integer pages ) {
    	
        Book book = new Book(title, desc, lang, pages);
        return bookService.createBook(book);
    }
    
    
    //Update method
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, 
    		           @RequestParam(value="title") String title, 
    		           @RequestParam(value="description") String desc, 
    		           @RequestParam(value="language") String lang, 
    		           @RequestParam(value="pages") Integer pages) {
    	
    	System.out.println(id + title + desc + lang + pages);
        Book book = bookService.updateBook(id, title, desc, lang, pages);
        System.out.println(book);
        return book;
    }
    
    //Delete method
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
}
