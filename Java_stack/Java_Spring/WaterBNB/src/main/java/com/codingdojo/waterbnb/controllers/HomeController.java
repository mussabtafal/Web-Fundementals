package com.codingdojo.waterbnb.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.waterbnb.models.LoginUser;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.services.UserService;


@Controller
public class HomeController {
    
    // Add once service is implemented:
    @Autowired
    private UserService userServ;
    
    
    @GetMapping("/guest/signin")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/guest/signin/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {

    	User user1= userServ.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }else {
        	if (user1.getStatus().equals("host")) {
        		session.setAttribute("user", user1);
                return "redirect:/dashboard"; 
        	}else {
        		session.setAttribute("user", user1);
                return "redirect:/"; 
        	}
        } 
      }

    
    @PostMapping("/guest/signin/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user1= userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }else {
        	if (user1.getStatus().equals("host")) {
        		session.setAttribute("user", user1);
                return "redirect:/dashboard"; 
        	}else {
        		session.setAttribute("user", user1);
                return "redirect:/"; 
        	}
        } 
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";
        
    }
    
    
}