package com.codingdojo.showbooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.showbooks.models.Book;
import com.codingdojo.showbooks.services.BookService;

@Controller
public class BooksController {
	//Attribute
    private final BookService bookService;
    
    //Constructor
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    
    //Display all books
    @RequestMapping( value = "/books", method=RequestMethod.GET )
    public String index(Model model) {
    	
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        System.out.println( books );
        return "index.jsp";
    }
    
    //Renders/Displays form to create book
    @RequestMapping(value = "/books/new", method=RequestMethod.GET)
    public String newBook(@ModelAttribute("book") Book book) {
        return "new.jsp";
    }
    
    //Creates book (grabs info and stores/save it)
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } 
        else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    // Displays/renders specific book by id
    @RequestMapping( value = "/books/{id}", method=RequestMethod.GET )
    public String show(@PathVariable( "id" ) Long id, Model model ) {
        Book book = bookService.findBook( id );
        model.addAttribute("book", book);
        return "show.jsp";
    }
    
    //Displays/renders the form to edit book by id
    @RequestMapping( value = "/books/{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    //Updates book by id
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } 
        else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
    //Deletes book by id
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    
}