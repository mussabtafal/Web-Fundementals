package com.codingdojo.yogacourse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.yogacourse.models.Course;
import com.codingdojo.yogacourse.models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	List <Student> findAll();
	Optional<Student> findByEmail(String email);
	List <Student> findByJoinedCoursesNotContains(Course course);
}
