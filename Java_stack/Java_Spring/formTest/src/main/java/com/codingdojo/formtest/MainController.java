package com.codingdojo.formtest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

@RequestMapping("/login")
public String login(
	@RequestParam(value="email") String email,
	@RequestParam(value="password") String password) {
    
    	// CODE TO PROCESS FORM ie. check email and password
    	
    	return "results.jsp"; // <-- we'll change this when we learn redirecting
}
}
