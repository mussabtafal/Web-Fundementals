package com.codingdojo.quarries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.quarries.models.Country;


public interface CountryRepository extends CrudRepository<Country, Long>{
	 @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
	 List<Object[]> joinDojosAndNinjas2();
}
