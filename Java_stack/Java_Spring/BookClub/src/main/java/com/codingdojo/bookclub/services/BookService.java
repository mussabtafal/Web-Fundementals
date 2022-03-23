package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
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
	 
	 public void delete(Long id) {
	    	Book deleteBook = bookRepo.findById(id).orElse(null); 
	    	bookRepo.delete(deleteBook);
	  	}
	 
	 public List<Book> toborrowBooks(Long id){
	        Optional <List<Book>> books = bookRepo.findByBorrowId(id);
	        if(books.isPresent()) {
	            return books.get();
	        }else {
	            return null;
	        }

	    }
	    public List<Book> borrowBooks(Long id){
	        Optional <List<Book>> books=bookRepo.findByBorrowId(id);
	        if(books.isPresent()) {
	            return books.get();
	        }else {
	            return null;
	        }

	    }

	    public Book borrow(Long id1 , User user) {
	        Book book1 = bookRepo.findById(id1).orElse(null);
	        assert book1!=null;
	        book1.setBorrow(user);

	        return bookRepo.save(book1);
	    }

	    public Book returnBook(Long id1 , User user) {
	        Book book1 = bookRepo.findById(id1).orElse(null);
	        assert book1!=null;
	        book1.setBorrow(null);

	        return bookRepo.save(book1);
	    }
	 
	 
}
