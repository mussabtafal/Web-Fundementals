package com.codingdojo.jspdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class JspDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JspDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String Demo() {
		return "index.jsp";
	}

}
