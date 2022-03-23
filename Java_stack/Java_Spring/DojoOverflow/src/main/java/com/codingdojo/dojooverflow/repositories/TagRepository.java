package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;



public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
//	List<Tag> findByQuestionsNotContains(Question question);
}
