package com.codingdojo.doctor.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotEmpty(message="Username is required!")
    @Size(min=3, message="Username must be greater than 3 characters")
    private String username;
    
    @NotEmpty(message="E-mail is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @Min(value = 18, message="User must be atleast 18 years old")
    private Integer age;
    
    private String status;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String passwordConfirmation;
    
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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Post> ownedPosts;
    
    @OneToMany(mappedBy="commentUser", fetch = FetchType.LAZY)
    private List<Comment> userComments;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_comments", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private List<Comment> likedComments;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Rating> ownedRatings;
    
    public User() {
    }
    
	public User(Long id, String username, String email, Integer age, String status, String password, String passwordConfirmation,
			List<Role> roles, List<Post> ownedPosts, List<Comment> userComments, List<Comment> likedComments,
			List<Rating> ownedRatings) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.age = age;
		this.status = status;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.roles = roles;
		this.ownedPosts = ownedPosts;
		this.userComments = userComments;
		this.likedComments = likedComments;
		this.ownedRatings = ownedRatings;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Post> getOwnedPosts() {
		return ownedPosts;
	}
	public void setOwnedPosts(List<Post> ownedPosts) {
		this.ownedPosts = ownedPosts;
	}
	public List<Comment> getUserComments() {
		return userComments;
	}
	public void setUserComments(List<Comment> userComments) {
		this.userComments = userComments;
	}
	public List<Comment> getLikedComments() {
		return likedComments;
	}
	public void setLikedComments(List<Comment> likedComments) {
		this.likedComments = likedComments;
	}
	public List<Rating> getOwnedRatings() {
		return ownedRatings;
	}
	public void setOwnedRatings(List<Rating> ownedRatings) {
		this.ownedRatings = ownedRatings;
	}
	
	 
    
    
    
}