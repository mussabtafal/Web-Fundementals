package com.codingdojo.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required = false) String name, String last_name, String times) {
    	if(name == null) {
    		return "Hello Human";
    	}
    	else if (last_name == null) {
    		if (Integer.parseInt(times) == 0) {
    			return "Hello " + name + " " + last_name;
    		}
    		else {
    			String sentence = "";
    			for (int i = 0; i < Integer.parseInt(times); i++) {
    				sentence += "Hello " + name + " ";
    			}
    			return sentence;
    		}
    	}
    	else {
    		return "Hello " + name + " " + last_name;
    	}
    }
}




