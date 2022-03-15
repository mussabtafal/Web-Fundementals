package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@SpringBootApplication
@Controller
public class BooksController {
	@Autowired
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "table.jsp";
	}
	
	@RequestMapping("/books/{bookid}")
	public String index(Model model, @PathVariable("bookid") Long bookId) {
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		return "main.jsp";
	}
	
}
