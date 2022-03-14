package com.codingdojo.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class OmikujiController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}

	
	@RequestMapping(value="/omikuji/process", method=RequestMethod.POST)
	public String process(HttpSession session,
		@RequestParam(value="number") Integer number,
		@RequestParam(value="city") String city,
		@RequestParam(value="name") String name,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="animal") String animal,
		@RequestParam(value="nice") String nice) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("animal", animal);
		session.setAttribute("nice", nice);
		
		 return "redirect:/omikuji/show"; 
	}

	@RequestMapping(value="/omikuji/show", method = RequestMethod.GET)
	public String show(Model model, HttpSession session) {
		Integer showNumber = (Integer)session.getAttribute("number");
		String showCity = (String) session.getAttribute("city");
		String showName = (String) session.getAttribute("name");
		String showHobby = (String) session.getAttribute("hobby");
		String showAnimal = (String) session.getAttribute("animal");
		String showNice = (String) session.getAttribute("nice");
		
		model.addAttribute("number", showNumber);
		model.addAttribute("city", showCity);
		model.addAttribute("name", showName);
		model.addAttribute("hobby", showHobby);
		model.addAttribute("animal", showAnimal);
		model.addAttribute("nice", showNice);
		
		return "show.jsp"; 
	}

}
