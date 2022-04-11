package com.codingdojo.events.models;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String name;
    
    @NotEmpty(message="Location is required!")
    @Size(min=3, max=30, message="Location must be between 3 and 30 characters")
    private String location;
    
    @NotEmpty(message="State is required!")
    @Size(min=1, max=3, message="State must be maximum 3 characters")
    private String state;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate eventDate;
    
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
    @JoinColumn(name="host_id")
    private User host;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "joined_users_events", 
        joinColumns = @JoinColumn(name = "joinedEvent_id"), 
        inverseJoinColumns = @JoinColumn(name = "JoinedUser_id")
    )
    private List<User> joinedUsers;
    
    @OneToMany(mappedBy="messageEvent", fetch = FetchType.LAZY)
    private List<Message> eventMessages;
    
	public Event() {
	}
	public Event(String name, String location, String state, LocalDate eventDate) {
		this.name = name;
		this.location = location;
		this.state = state;
		this.eventDate = eventDate;
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
	public LocalDate getEventDate() {
		return eventDate;
	}
	
	
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<User> getJoinedUsers() {
		return joinedUsers;
	}
	public void setJoinedUsers(List<User> joinedUsers) {
		this.joinedUsers = joinedUsers;
	}
	public List<Message> getEventMessages() {
		return eventMessages;
	}
	public void setEventMessages(List<Message> eventMessages) {
		this.eventMessages = eventMessages;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
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
	
    
    
}
