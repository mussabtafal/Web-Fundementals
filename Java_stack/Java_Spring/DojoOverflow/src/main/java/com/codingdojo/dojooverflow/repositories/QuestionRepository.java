package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.dojooverflow.models.Question;
//import com.codingdojo.dojooverflow.models.Tag;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
//	List<Question> findByTagsNotContains(Tag tag);
}
