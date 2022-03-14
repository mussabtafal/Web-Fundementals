package com.codingdojo.datetime;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DateTimeController {
	
	 @RequestMapping("/")
	    public String main() {
	        return "Main.jsp";
	    }
	 
	 @RequestMapping("/time")
	    public String time() {
	        return "Time.jsp";
	    }
	 
	 @RequestMapping("/date")
	    public String date() {
	        return "Date.jsp";
	    }
}
