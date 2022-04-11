package com.codingdojo.yogacourse.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.yogacourse.models.Course;
import com.codingdojo.yogacourse.models.Student;
import com.codingdojo.yogacourse.repositories.StudentRepository;


@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	 public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	 public List<Student> findAllStudents(){
	        return studentRepository.findAll();
	    }
	 
	 public Student createStudent(Student student, BindingResult result) {
	        Optional<Student> potentialStudent = studentRepository.findByEmail(student.getEmail());
	        if(potentialStudent.isPresent()) {
	               result.rejectValue("email", "Exist", "This email already exist!");
	               return null;
	           }if (result.hasErrors()) {
	                return null;
	           }else {
	               return studentRepository.save(student);
	           }
	       }
	
	 public Student findStudentById (Long id) {
	    	Optional<Student> thisStudent = studentRepository.findById(id);
	    	return thisStudent.get();
	    }

	 public List<Student> notStudents(Course course){
	        return studentRepository.findByJoinedCoursesNotContains(course);
	    }
	

}
