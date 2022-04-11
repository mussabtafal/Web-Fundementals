package com.codingdojo.waterbnb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.waterbnb.models.Listing;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.services.ListingService;
import com.codingdojo.waterbnb.services.ReviewService;

@Controller
public class WaterController {
	private final ListingService listingService;
	private final ReviewService reviewService;
	
	public WaterController(ListingService listingService, ReviewService reviewService) {
		this.listingService = listingService;
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/")
	public String Landing () {
		return "Landing.jsp";
	}
	
	@GetMapping("/search")
	public String Search(@RequestParam(value="location", required=true) String searchQuery, Model model) {
		List<Listing> locationSearch = listingService.containAddress(searchQuery);
		System.out.println(locationSearch);
		System.out.println(searchQuery);
		model.addAttribute("locations", locationSearch);
		return "Search.jsp";
	}
	
	@GetMapping("/host/dashboard")
    public String dashboard( @ModelAttribute("listing") Listing listing ,BindingResult result,Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            User thisUser = (User) session.getAttribute("user");
            model.addAttribute("user", session.getAttribute("user")); 
            List <Listing>listings= thisUser.getOwnedListings();
            model.addAttribute("listings", listings); 
            return "Dashboard.jsp";
        } else {
            return "redirect:/guest/signin";
        }

    }

    @PostMapping("/host/dashboard")
    public String addListing(@Valid @ModelAttribute("listing") Listing listing ,BindingResult result,Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (result.hasErrors()) {
                User thisUser = (User) session.getAttribute("user");
                model.addAttribute("user", session.getAttribute("user")); 
                return "Dashboard.jsp";
            }else {
                listingService.createListing(listing);
                return "redirect:/host/dashboard";
            } 
        }
        else {
            return "redirect:/guest/signin";
    }
    }
	
}
