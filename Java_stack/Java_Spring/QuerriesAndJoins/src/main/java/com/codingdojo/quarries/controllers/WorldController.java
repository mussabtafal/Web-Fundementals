package com.codingdojo.quarries.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.quarries.services.WorldService;

@RestController
public class WorldController {
	private final WorldService worldService;
	

	public WorldController(WorldService worldService) {
		this.worldService = worldService;
	}

	@RequestMapping("/")
    public void query1(){
        String lang= "Slovene";
        worldService.query1(lang);
    }

    @RequestMapping("/city")
    public void query2(){
        worldService.query2();
    }

    @RequestMapping("/pop")
    public void query3(){
        worldService.query3();
    }

    @RequestMapping("/per")
    public void query4(){
        worldService.query4();
    }

    @RequestMapping("/country")
    public void query5(){
        worldService.query5();
    }
    @RequestMapping("/exp")
    public void query6(){
        worldService.query6();
    }
    @RequestMapping("/3")
    public void query7(){
        worldService.query7();
    }

    @RequestMapping("/1")
    public void query8(){
        worldService.query8();
    }
	
	
}
