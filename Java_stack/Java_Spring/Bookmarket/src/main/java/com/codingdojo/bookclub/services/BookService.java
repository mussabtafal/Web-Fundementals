package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService {
	 @Autowired
	 private BookRepository bookRepo;
	 
	 
	 public List<Book> FindAll(){
		return bookRepo.findAll();
	 }
	 
	 
	 public Book FindBook(Long id) {
		 Optional<Book> thisBook = bookRepo.findById(id);
		 if (thisBook.isPresent()) {
			 return thisBook.get();
		 }
		 else {
			 return null;
		 }
	 }
	 
	 public Book createBook(Book b) {
		 return bookRepo.save(b);
	 }
	 
	 public Book updateBook(Book book) {
	        Book book1 = bookRepo.findById(book.getId()).orElse(null);
	        assert book1!=null;
	        book1.setTitle(book.getTitle());
	        book1.setAuthor(book.getAuthor());
	        book1.setThought(book.getThought());
	        return bookRepo.save(book1);
	    }
	 
	 
}
