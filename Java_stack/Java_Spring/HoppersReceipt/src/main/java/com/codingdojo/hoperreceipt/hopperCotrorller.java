package com.codingdojo.hoperreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hopperCotrorller {
	  @RequestMapping("/")
	    public String index(Model model) {
	        
	        String name = "Mussab Taffal";
	        String itemName = "Copper wire";
	        double price = 5.25;
	        String description = "Metal strips, also an illustration of nanoseconds.";
	        String vendor = "Little Things Corner Store";
	    
	    	// Your code here! Add values to the view model to be rendered
	        model.addAttribute("fullname", name);
	        model.addAttribute("item", itemName);
	        model.addAttribute("itemprice", price);
	        model.addAttribute("desc", description);
	        model.addAttribute("supplier", vendor);
	    
	        return "index.jsp";
	    }
}
