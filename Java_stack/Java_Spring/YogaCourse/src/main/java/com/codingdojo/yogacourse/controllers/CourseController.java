package com.codingdojo.yogacourse.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.yogacourse.models.Course;
import com.codingdojo.yogacourse.models.Student;
import com.codingdojo.yogacourse.models.User;
import com.codingdojo.yogacourse.services.CourseService;
import com.codingdojo.yogacourse.services.StudentService;

@Controller
public class CourseController {
	private final CourseService courseService;
	private final StudentService studentService;

	public CourseController(CourseService courseService, StudentService studentService) {
		this.courseService = courseService;
		this.studentService = studentService;
	}
	
	
	@GetMapping("/classes")
	public String ClassPage (HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			List<Course> AllCourses = courseService.findAllCourses();
			model.addAttribute("courses", AllCourses);
			model.addAttribute("user", thisUser);
			return "Classes.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/classes/new")
	public String newCourse(@ModelAttribute("course") Course course, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "CourseForm.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/classes/new")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			System.out.println(course.getCourseTime());
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				return "CourseForm.jsp";
			}else {
				Course newCourse = courseService.creatCourse(course);
				return "redirect:/classes/" + newCourse.getId();
			}
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/classes/{courseId}")
    public String showCourse (@PathVariable("courseId") Long id, @ModelAttribute("student") Student student, BindingResult result, HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            User thisUser = (User) session.getAttribute("user");
            model.addAttribute("user", session.getAttribute("user"));
            Course thisCourse = courseService.findCoursesById(id);
            model.addAttribute("course",thisCourse);
            List<Student> theseStudents = thisCourse.getJoinedStudents();
			model.addAttribute("students",theseStudents);
			List<Student> allStudents = studentService.notStudents(thisCourse);
			model.addAttribute("allStudents",allStudents);
            return "ShowClass.jsp";
        }else {
            return "redirect:/";
        }
    }
	@PostMapping("/classes/{courseId}")
	public String createStudent(@PathVariable("courseId") Long id, @Valid @ModelAttribute("student") Student student, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Student newStudent = studentService.createStudent(student, result);
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user"));
				Course thisCourse = courseService.findCoursesById(id);
				model.addAttribute("course",thisCourse);
				List<Student> theseStudents = thisCourse.getJoinedStudents();
				model.addAttribute("students",theseStudents);
				List<Student> allStudents = studentService.notStudents(thisCourse);
				model.addAttribute("allStudents",allStudents);
				return "ShowClass.jsp";
			}else {
				return "redirect:/classes/" + id + "/relate/" + newStudent.getId()  ;
			}
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/classes/{courseId}/relate/{studentId}")
	public String joinClass (@PathVariable ("courseId") Long classId, @PathVariable ("studentId") Long studId, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			Course thisCourse = courseService.findCoursesById(studId);
			Student thisStudent = studentService.findStudentById(studId);
			courseService.joinCourse(thisStudent, thisCourse);
			return "redirect:/classes/" + thisCourse.getId();
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/classes/{courseId}/relating")
    public String joinClasses (@PathVariable ("courseId") Long id,HttpSession session,@RequestParam("st") Long sid) {
        if (session.getAttribute("user") != null) {
            User thisUser = (User) session.getAttribute("user");
            Course thisCourse = courseService.findCoursesById(id);
            Student student = studentService.findStudentById(sid);
            courseService.joinCourse(student, thisCourse);
            return "redirect:/classes/" + thisCourse.getId();
        }else {
            return "redirect:/";
        }
    }

//	
	@GetMapping("/classes/{courseId}/edit")
	public String editClass(@PathVariable("courseId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Course thisCourse = courseService.findCoursesById(id);
			model.addAttribute("course",thisCourse);
			return "EditClass.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	
	@PutMapping("/classes/{id}/edit")
    public String updateCourse(@Valid @ModelAttribute("course") Course course ,BindingResult result ,@PathVariable("id")Long id,Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (result.hasErrors()) {
                model.addAttribute("user", session.getAttribute("user"));
                return "EditClass.jsp";
            }else {
                courseService.updateCourse(course);
                return "redirect:/classes"   ;
            }
        } else {
            return "redirect:/";
        }
    }
	
	@DeleteMapping("/classes/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        
        return "redirect:/classes";
    }
	
	
}
	



