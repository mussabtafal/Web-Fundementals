package com.codingdojo.dojoflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.dojoflow.models.Answer;


@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List <Answer> findAll();
}
