package com.codingdojo.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Project;
import com.codingdojo.project.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List <Project> findAll();
	List <Project> findByJoinedUsersNotContains(User user);
	List <Project> findByJoinedUsersContains(User user);
	Optional<Project> findById(Long id);
}
