package com.codingdojo.quarries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.quarries.models.Country;


public interface CountryRepository extends CrudRepository<Country, Long>{
	@Query("SELECT c,l FROM Country c JOIN c.languages l WHERE language = ?1 order by l.percentage desc")
    List<Object[]> joinCountryAndLanguage(String language);
    
    @Query(value="SELECT countries.name, count(cities.id) as total FROM countries JOIN cities on countries.id = cities.country_id GROUP BY countries.name ORDER BY total DESC ;", nativeQuery=true)
    List<Object[]> joinCountryAndCities();
    
    @Query(value="SELECT countries.name as x, cities.name, cities.population FROM countries JOIN cities on countries.id = cities.country_id WHERE countries.name = 'Mexico'  and cities.population > 500000  ;", nativeQuery=true)
    List<Object[]> nameCitiesInCountries();
    
    @Query(value="SELECT countries.name, languages.language, languages.percentage FROM countries JOIN languages on countries.id = languages.country_id WHERE languages.percentage > '89%' ORDER BY languages.percentage DESC ;", nativeQuery=true)
    List<Object[]> percentageInCountries();
    
    @Query(value="SELECT countries.name FROM countries JOIN cities on countries.id = cities.country_id WHERE  countries.population > 100000 and countries.surface_area < 501 ;", nativeQuery=true)
    List<Object[]> popCountries();
    
    @Query(value="SELECT countries.name FROM countries JOIN cities on countries.id = cities.country_id WHERE  countries.life_expectancy > 75 and countries.surface_area < 200 and countries.government_form = 'Constitutional Monarchy' ;", nativeQuery=true)
    List<Object[]> expCountries();
    
    @Query(value="SELECT countries.name as x, cities.district, cities.name, cities.population FROM countries\r\n"
            + "JOIN cities ON countries.id = cities.country_id\r\n"
            + "WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000\r\n"
            + " ;", nativeQuery=true)
    List<Object[]> Countries();
    
    @Query(value="SELECT countries.region, COUNT(countries.name) FROM countries\r\n"
            + "GROUP BY countries.region\r\n"
            + "ORDER BY COUNT(countries.name) DESC\r\n"
            + " ;", nativeQuery=true)
    List<Object[]> regionCountries();
}
