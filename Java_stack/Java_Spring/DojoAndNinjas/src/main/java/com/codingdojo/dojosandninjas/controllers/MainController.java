package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;



@SpringBootApplication
@Controller
public class MainController {
	
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService= ninjaService;
	}
	
	@RequestMapping("ninjas/new")
    public String Ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojo();
		model.addAttribute("dojos", allDojos);
        return "ninja.jsp";
    }
	
	@PostMapping("/ninjas/new")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "ninja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/dojos/"+ ninja.getDojo().getId();
        }
    }
	
	
	@GetMapping("/dojos/new")
    public String Dojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojo.jsp";
    }
	
   @PostMapping("/dojos/new")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
        	model.addAttribute(dojo);
            return "redirect:/dojos/"+ dojo.getId();
        }
    }
   
   @GetMapping("/dojos/{id}")
   public String show(@PathVariable("id") Long id, Model model) {
   	Dojo dojo = dojoService.findDojo(id);
   	List<Ninja> allDojoNinjas = dojo.getNinjas();
       model.addAttribute("dojo", allDojoNinjas);
       return "main.jsp";
   }
	
}
