package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;


@SpringBootApplication
@Controller
public class BookController {
	
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public String Dashboard (Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			List <Book> books  = bookService.FindAll();
			model.addAttribute("books", books);
			model.addAttribute("user", session.getAttribute("user"));
			return "AllBooks.jsp";
		}else {
			return "redirect:/";
		}
		
	}
	
	
	@GetMapping("/books/new")
	public String newForm(@ModelAttribute("book") Book book, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "BookForm.jsp";
		}
		else {
			return "redirect:/";
		}
		
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				return "BookForm.jsp";
			}else {
				bookService.createBook(book);
				return "redirect:/books";
			}
		}
		else {
			return "redirect:/";
		}		
	}
	
	@GetMapping("/books/{bookId}")
	public String ShowBook (@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Book thisBook = bookService.FindBook(id);
			model.addAttribute("book", thisBook);
			User user = (User)session.getAttribute("user");
			if (user.getId().equals(thisBook.getUser().getId())) {
				model.addAttribute("name1", "You");
				model.addAttribute("name2", "your");
				session.setAttribute("edit", session.getAttribute("user"));
			}
			else {
				model.addAttribute("name1", thisBook.getUser().getUserName());
				model.addAttribute("name2", thisBook.getUser().getUserName() + "'s");
			}
			return "BookDetail.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/books/{bookId}/edit")
	public String editForm(@PathVariable("bookId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Book thisBook = bookService.FindBook(id);
			model.addAttribute("book", thisBook);
			return "BookEdit.jsp";
		}
		else {
			return "redirect:/";
		}
		
	}
	
	
	@PutMapping("/books/{id}/edit")
    public String updateBook (@Valid @ModelAttribute("book") Book book, BindingResult result,@PathVariable("id") Long id,Model model,HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (result.hasErrors()) {
                model.addAttribute("user", session.getAttribute("user"));
                return "BookEdit.jsp";
            }else {
                bookService.updateBook(book);
                return "redirect:/books/"+id;
            }
        }
        else {
            return "redirect:/";
        }
	
	}
	
		
	  @GetMapping("/bookmarket")
	    public String Bookmarket(HttpSession session, Model model) {
	        if (session.getAttribute("user") != null) {
	            model.addAttribute("user", session.getAttribute("user"));
	            User user = (User) session.getAttribute("user");
	            List<Book> allBooks = bookService.toborrowBooks(null);
	            List<Book> borrowBooks = bookService.borrowBooks(user.getId());
	            model.addAttribute("borrowed", borrowBooks);
	            model.addAttribute("allbooks", allBooks);
	            return "Bookmarket.jsp";
	        }
	        else {
	            return "redirect:/";
	        }

	    }

	    @GetMapping("/books/{id}/borrow")
	     public String borrowBook(@PathVariable("id") Long id, Model model,HttpSession session) {
	        if (session.getAttribute("user") != null) {
	            model.addAttribute("user", session.getAttribute("user"));
	            Book book = bookService.FindBook(id);
	            model.addAttribute("book",book);
	            User user = (User) session.getAttribute("user");
	            bookService.borrow(id, user);
	            return "redirect:/bookmarket";
	       }else {
	           return "redirect:/";
	       }
	    }

	    @GetMapping("/books/{id}/return")
	     public String returnBook(@PathVariable("id") Long id, Model model,HttpSession session) {
	        if (session.getAttribute("user") != null) {
	            model.addAttribute("user", session.getAttribute("user"));
	            Book book = bookService.FindBook(id);
	            model.addAttribute("book",book);
	            User user = (User) session.getAttribute("user");
	            bookService.returnBook(id, user);
	            return "redirect:/bookmarket";
	      }else {
	          return "redirect:/";
	      }
	    }

	    @DeleteMapping("/books/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        bookService.delete(id);
	        return "redirect:/bookmarket";
	    }

	
}
