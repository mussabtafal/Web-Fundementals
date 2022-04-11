package com.codingdojo.dojoflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoflow.models.Tag;


@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List <Tag> findAll();
	Boolean existsBySubject(String subject);
	Optional<Tag> findBySubject(String subject);
}
