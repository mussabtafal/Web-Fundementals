package com.codingdojo.quarries.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.quarries.models.Country;
import com.codingdojo.quarries.models.Language;
import com.codingdojo.quarries.repositories.CountryRepository;

@Service
public class WorldService {
	private final CountryRepository countryRepository;

	public WorldService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public void QuerryOne (String language) {
		List<Object[]> table = countryRepository.joinCountryAndLanguage(language);
		for(Object[] row : table) {
		    Country country = (Country) row[0];
		    Language lang = (Language) row[1];
		    System.out.println(country.getName());
		    System.out.println(lang.getLanguage());
		    System.out.println(lang.getPercentage());
		}
	}
	
	public void query1(String language){
        List<Object[]> table = countryRepository.joinCountryAndLanguage(language);
        for(Object[] row : table) {
            Country country = (Country) row[0];
            Language lang = (Language) row[1];
            System.out.println(country.getName());
            System.out.println(lang.getLanguage());
            System.out.println(lang.getPercentage());
    }
    }
    public void query2(){
        List<Object[]> table = countryRepository.joinCountryAndCities();
        for(Object[] row : table) {
            String country = (String) row[0];
            BigInteger count  = (BigInteger) row[1];
            System.out.println(country);
            System.out.println(count);
    }
    }
    
    public void query3(){
        List<Object[]> table = countryRepository.nameCitiesInCountries();
        for(Object[] row : table) {
            String country = (String) row[0];
            String city = (String) row[1];
            Integer population  = (Integer) row[2];
            System.out.println(country);
            System.out.println(city);
            System.out.println(population);
    }
    }
    
    public void query4(){
        List<Object[]> table = countryRepository.percentageInCountries();
        for(Object[] row : table) {            
            String country = (String) row[0];
            String lang = (String) row[1];
            Float percentage  = (Float) row[2];
            System.out.println(country);
            System.out.println(lang);
            System.out.println(percentage);
    }
    }
    public void query5(){
        List<Object[]> table = countryRepository.popCountries();
        for(Object[] row : table) {            
            String country = (String) row[0];
            System.out.println(country);
    }
    }
    public void query6(){
        List<Object[]> table = countryRepository.expCountries();
        for(Object[] row : table) {            
            String country = (String) row[0];
            System.out.println(country);
    }
    }
    
    public void query7(){
        List<Object[]> table = countryRepository.Countries();
        for(Object[] row : table) {            
            String country = (String) row[0];
            String dist = (String) row[1];
            String city = (String) row[2];
            Integer population  = (Integer) row[3];
            System.out.println(country);
            System.out.println(dist);
            System.out.println(city);
            System.out.println(population);
    }
    }
    
    public void query8(){
        List<Object[]> table = countryRepository.regionCountries();
        for(Object[] row : table) {            
            String country = (String) row[0];
            BigInteger count  = (BigInteger) row[1];
            System.out.println(country);
            System.out.println(count);
    }
    }
	
}
