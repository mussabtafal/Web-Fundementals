package com.codingdojo.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("")
	public String index() {
		return "Welcome";
	}
	
	@RequestMapping("daikichi/Today")
	public String today() {
		return "Today you will find luck in all your endeavors";
	}
	
	@RequestMapping("daikichi/Tomorrow")
	public String Tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/")
	public String Search(@RequestParam(value = "name", required = false) String first_name, String last_name, String Times ) {
		String sentence = "";
		for (int i = 0; i < Integer.parseInt(Times); i++) {
			sentence += "Hello " + first_name + " " + last_name + " ";
		}
		return sentence;
	}
	
	@RequestMapping("/{name}/{country}/{age}")
	public String Person(@PathVariable("name") String name, @PathVariable("country") String country, @PathVariable("age") String age ) {
		return "My Name is " + name + ", I come from " + country + " and I am " + age + " Years old.";
	}
	
}
