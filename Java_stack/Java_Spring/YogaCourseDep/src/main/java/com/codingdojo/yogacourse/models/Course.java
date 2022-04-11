package com.codingdojo.yogacourse.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String name;
    
    @NotEmpty(message="Day of the Week is required!")
    @Size(min=3, max=15, message="Day of the Week must be atleast 3 characters")
    private String weekDay;
    
    private double price;
    
    @NotNull(message="Time is required!")
    @DateTimeFormat(pattern="h:m a")
    private Date courseTime;
    
    @NotEmpty(message="Description is required!")
    @Size(min=10, message="Description must be atleast 10 characters")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="instructor_id")
    private User instructor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "joined_students_courses", 
        joinColumns = @JoinColumn(name = "JoinedCourse_id"), 
        inverseJoinColumns = @JoinColumn(name = "joinedStudent_id")
    )
    private List<Student> joinedStudents;

	public Course() {

	}
	public Course(String name,String weekDay,double price, Date courseTime, String description) {
		this.name = name;
		this.weekDay = weekDay;
		this.price = price;
		this.courseTime = courseTime;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Date courseTime) {
		this.courseTime = courseTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getInstructor() {
		return instructor;
	}
	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}
	public List<Student> getJoinedStudents() {
		return joinedStudents;
	}
	public void setJoinedStudents(List<Student> joinedStudents) {
		this.joinedStudents = joinedStudents;
	}
	
 
}
