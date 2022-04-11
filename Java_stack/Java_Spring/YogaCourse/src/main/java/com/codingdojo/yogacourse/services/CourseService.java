package com.codingdojo.yogacourse.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.codingdojo.yogacourse.models.Course;
import com.codingdojo.yogacourse.models.Student;
import com.codingdojo.yogacourse.repositories.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	
    public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }


	public Course findCoursesById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            return null;
        }
    }

    public Course creatCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
    	Course editcourse = courseRepository.findById(course.getId()).orElse(null);
        assert editcourse!=null;
        editcourse.setName(course.getName());
        editcourse.setWeekDay(course.getWeekDay());
        editcourse.setPrice(course.getPrice());
        editcourse.setCourseTime(course.getCourseTime());
        editcourse.setDescription(course.getDescription());
        return courseRepository.save(editcourse);
    }
    
	public void deleteCourse(Long id) {
		Course thisCourse = courseRepository.findById(id).orElse(null);
		courseRepository.delete(thisCourse);
	}
    
  //Relating Users with Projects as either TeamLeaders or JoinTeams
	
  	public Course joinCourse (Student student, Course course) {
  		course.getJoinedStudents().add(student);
  		return courseRepository.save(course);
  	}
  	
    
}
