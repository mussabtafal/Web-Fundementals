package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;





@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	 public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	 
	 public List<Dojo> allDojo() {
	        return dojoRepository.findAll();
	    }
	 
	 public Dojo createDojo(Dojo e) {
	        return dojoRepository.save(e);
	    }
	 
	 public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	 
	
}
