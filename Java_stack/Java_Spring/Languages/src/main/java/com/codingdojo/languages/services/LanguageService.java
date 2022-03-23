package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;



@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	 public LanguageService(LanguageRepository languageRepository) {
	        this.languageRepository = languageRepository;
	    }
	 public List<Language> allLanguages() {
	        return languageRepository.findAll();
	    }
	 public Language findLanguage(Long id) {
	        Optional<Language> optionalLanguage = languageRepository.findById(id);
	        if(optionalLanguage.isPresent()) {
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
	 public Language createLanguage(Language e) {
	        return languageRepository.save(e);
	    }
	    
	    public Language updateLanguage(Long id, String name, String creator, String version) {
	    	Language languageUpdate = this.findLanguage(id); 
			if (languageUpdate != null) {
				languageUpdate.setName(name);
				languageUpdate.setCreator(creator);
				languageUpdate.setVersion(version);
				
				return languageRepository.save(languageUpdate);
			}
			else {
				return null;
			}
		}
	    
	    public void updateLanguage(Language language) {
	    	Language editedLanguage = languageRepository.findById(language.getId()).orElse(null); 
	  		assert editedLanguage != null;
	  		editedLanguage.setName(language.getName());
	  		editedLanguage.setCreator(language.getCreator());
	  		editedLanguage.setVersion(language.getVersion());
	  			
	  		languageRepository.save(editedLanguage);
	  	}
	    
	    public void deleteLanguage(Long id) {
	    	Language deleteLanguage = languageRepository.findById(id).orElse(null); 
	    	languageRepository.delete(deleteLanguage);
	  	}
	    
	 
	 
}
