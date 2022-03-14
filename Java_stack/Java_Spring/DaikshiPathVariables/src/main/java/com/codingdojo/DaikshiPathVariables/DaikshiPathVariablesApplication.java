package com.codingdojo.DaikshiPathVariables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DaikshiPathVariablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikshiPathVariablesApplication.class, args);
	}
	
    @RequestMapping("/daikichi/travel/{city}")
    public String showTravel(@PathVariable("city") String city){
    	return "Congratulations! You will soon travel to " + city + "!";
    }
    
    @RequestMapping("/daikichi/lotto/{num}")
    public String showLotto(@PathVariable("num") String num){
    	if(Integer.parseInt(num)%2 == 0) {
    		return "You will take a grand journey in the near future, but be weary of tempting offers";
    	}
    	else {
    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    	}
    	
    }

}
