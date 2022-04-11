package com.codingdojo.events.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Firstname is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String firstName;
    
    @NotEmpty(message="Lastname is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String lastName;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Location is required!")
    @Size(min=3, max=30, message="Location must be between 3 and 30 characters")
    private String location;
    
    @NotEmpty(message="State is required!")
    @Size(min=1, max=3, message="State must be maximum 3 characters")
    private String state;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
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
    
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> ownedEvents;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "joined_users_events", 
        joinColumns = @JoinColumn(name = "joinedUser_id"), 
        inverseJoinColumns = @JoinColumn(name = "JoinedEvent_id")
    )
    private List<Event> joinedEvents;
    
    @OneToMany(mappedBy="messageUser", fetch = FetchType.LAZY)
    private List<Message> userMessages;


    public User() {
    }

    public User( String firstName, String lastName, String email, String location, String state, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public List<Event> getOwnedEvents() {
		return ownedEvents;
	}
	public void setOwnedEvents(List<Event> ownedEvents) {
		this.ownedEvents = ownedEvents;
	}
	public List<Event> getJoinedEvents() {
		return joinedEvents;
	}
	public void setJoinedEvents(List<Event> joinedEvents) {
		this.joinedEvents = joinedEvents;
	}
	public List<Message> getUserMessages() {
		return userMessages;
	}
	public void setUserMessages(List<Message> userMessages) {
		this.userMessages = userMessages;
	}
    
    
    
}