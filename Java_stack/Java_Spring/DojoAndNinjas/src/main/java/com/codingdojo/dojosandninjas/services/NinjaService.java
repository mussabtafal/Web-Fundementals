package com.codingdojo.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;



@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
	
	public List<Ninja> allNinja() {
        return ninjaRepository.findAll();
    }
	
	public Ninja createNinja(Ninja e) {
	        return ninjaRepository.save(e);
	    }
	
}
