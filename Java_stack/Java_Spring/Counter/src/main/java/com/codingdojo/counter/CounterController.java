package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CounterController {
	
		@RequestMapping("/")
	    public String index(HttpSession session) {
			Integer count = (Integer)session.getAttribute("count"); 
			if (session.getAttribute("count") == null) {
				count = 0;
				session.setAttribute("count", count);
			}
			
			else {
				session.setAttribute("count", ++count);
			}
	        return "index.jsp";
		}
		
		@RequestMapping("/plustwo")
		public String indexPlusTwo(HttpSession session) {
			Integer count = (Integer)session.getAttribute("count"); 
			if (session.getAttribute("count") == null) {
				count = 0;
				session.setAttribute("count", count);
			}
			
			else {
				session.setAttribute("count", count + 2);
			}
	        return "plusTwoCount.jsp";
		}
		
		@RequestMapping("/counter")
	    public String counter(Model model, HttpSession session) {
			Integer visitCount = (Integer)session.getAttribute("count");
	        model.addAttribute("counter", visitCount);
	        return "showCounter.jsp";
		}
		
		@RequestMapping("/delete")
	    public String counter(HttpSession session) {
			session.setAttribute("count", 0);
	        return "index.jsp";
		}


}
